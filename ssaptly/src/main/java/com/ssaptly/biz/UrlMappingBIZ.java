package com.ssaptly.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssaptly.dao.UrlMappingDAO;
import com.ssaptly.utils.Base62Codec;
import com.ssaptly.vo.UrlMappingVO;

@Service
public class UrlMappingBIZ {
	private static final int DATABASE_ERROR_FLAG = 0;
	private static final String DATABASE_ERROR_MSG = "DB 오류입니다";
	private static final String SSAPTLY_PREFIX = "http://localhost:8888/";

	@Autowired
	UrlMappingDAO urlMappingDAO;

	@Transactional
	public String shortenUrl(String url) {
		long no = 0;
		try {
			urlMappingDAO.addUrlMappingByOriginUrl(url);
			no = urlMappingDAO.findLastNoByOriginUrl();
		} catch (Exception e) {
			no = urlMappingDAO.findNoByOriginUrl(url);
		}
		String shortUrl = Base62Codec.encode(no);	
		if(urlMappingDAO.updateShortUrl(shortUrl, no) == DATABASE_ERROR_FLAG) {
			return DATABASE_ERROR_MSG;
		}
		return SSAPTLY_PREFIX + shortUrl;
	}

	public UrlMappingVO findByOriginUrl(String originUrl) {
		return urlMappingDAO.findByOriginUrl(originUrl);
	}

	public UrlMappingVO findByShortUrl(String shortUrl) {
		return urlMappingDAO.findByOriginUrl(shortUrl);
	}

}
