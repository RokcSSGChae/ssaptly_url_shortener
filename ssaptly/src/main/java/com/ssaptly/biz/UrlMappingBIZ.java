package com.ssaptly.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssaptly.dao.UrlMappingDAO;
import com.ssaptly.utils.Base62Codec;
import com.ssaptly.utils.UrlConverter;

@Service
public class UrlMappingBIZ {
	private static final int DATABASE_ERROR_FLAG = 0;
	private static final String DATABASE_ERROR_MSG = "DB 오류입니다";

	@Autowired
	UrlMappingDAO urlMappingDAO;

	public String shortenUrl(String url) {
		String alreadyExistUrl = urlMappingDAO.findShortUrlByOriginUrl(url);
		if(alreadyExistUrl != null) {
			return UrlConverter.convertShortUrlWithDomain(alreadyExistUrl);
		}
		urlMappingDAO.addUrlMappingByOriginUrl(url);
		long no = urlMappingDAO.findNoByOriginUrl(url);
		String shortUrl = Base62Codec.encode(no);
		if(urlMappingDAO.updateShortUrl(shortUrl, no) == DATABASE_ERROR_FLAG) {
			return DATABASE_ERROR_MSG;
		}
		return UrlConverter.convertShortUrlWithDomain(url);
	}

	public String findOriginUrlByShortUrl(String url) {
		return urlMappingDAO.findOriginUrlByShortUrl(url);
	}
}
