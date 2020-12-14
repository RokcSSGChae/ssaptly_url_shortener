package com.ssaptly.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ssaptly.vo.UrlMappingVO;

@Repository
public class UrlMappingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addUrlMappingByOriginUrl(String originUrl) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO URL_MAPPING(NO, ORIGIN_URL, SHORTEN_DATE) ");
		query.append("VALUES(URL_MAPPING_SEQ.NEXTVAL, ?, SYSDATE)");

		return jdbcTemplate.update(query.toString(), originUrl);
	};

	public long findLastNoByOriginUrl() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT NO ");
		query.append("FROM URL_MAPPING ");
		query.append("WHERE ROWNUM = 1 ");
		query.append("ORDER BY NO DESC");

		return jdbcTemplate.queryForObject(query.toString(), Long.class);
	}

	public long findNoByOriginUrl(String originUrl) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT NO ");
		query.append("FROM URL_MAPPING ");
		query.append("WHERE ORIGIN_URL = ?");

		return jdbcTemplate.queryForObject(query.toString(), Long.class, originUrl);
	}
	
	public int updateShortUrl(String shortUrl, long no) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE URL_MAPPING ");
		query.append("SET SHORT_URL = ? ");
		query.append("WHERE NO = ?");
		
		return jdbcTemplate.update(query.toString(), shortUrl, no);
	}

	public UrlMappingVO findByOriginUrl(String originUrl) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM URL_MAPPING ");
		query.append("WHERE DBMS_LOB.COMPARE(ORIGIN_URL, TO_CLOB(?)) = 0");

		UrlMappingVO vo = jdbcTemplate.queryForObject(query.toString(), (resultSet, rowNum) -> {
			UrlMappingVO newVo = new UrlMappingVO();
			newVo.setNo(resultSet.getLong("NO"));
			newVo.setOriginUrl(resultSet.getString("ORIGIN_URL"));
			newVo.setShortUrl(resultSet.getString("SHORT_URL"));
			newVo.setDate(resultSet.getDate("SHORTEN_DATE"));
			return newVo;
		}, originUrl);

		return vo;
	}

	public UrlMappingVO findByShortUrl(String shortUrl) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM URL_MAPPING ");
		query.append("WHERE SHORT_URL = ?");

		UrlMappingVO vo = jdbcTemplate.queryForObject(query.toString(), (resultSet, rowNum) -> {
			UrlMappingVO newVo = new UrlMappingVO();
			newVo.setNo(resultSet.getLong("NO"));
			newVo.setOriginUrl(resultSet.getString("ORIGIN_URL"));
			newVo.setShortUrl(resultSet.getString("SHORT_URL"));
			newVo.setDate(resultSet.getDate("SHORTEN_DATE"));
			return newVo;
		}, shortUrl);

		return vo;
	}
}
