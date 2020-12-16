package com.ssaptly.dao;

import static com.ssaptly.dao.stmt.UrlMappingSQLStatements.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlMappingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Long findNoByOriginUrl(String originUrl) {
		try {
			return jdbcTemplate.queryForObject(
					findNoByOriginUrl, 
					Long.class, 
					originUrl);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public String findOriginUrlByShortUrl(String shortUrl) {
		try {
			return jdbcTemplate.queryForObject(
					findOriginUrlByShortUrl, 
					String.class, 
					shortUrl);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public String findShortUrlByOriginUrl(String originUrl) {
		try {
			return jdbcTemplate.queryForObject(
					findShortUrlByOriginUrl, 
					String.class, 
					originUrl);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Integer addUrlMappingByOriginUrl(String originUrl) {
		return jdbcTemplate.update(
				addUrlMappingByOriginUrl, 
				originUrl);
	};

	public Integer updateShortUrl(String shortUrl, long no) {
		return jdbcTemplate.update(updateShortUrl,
				shortUrl, 
				no);
	}
}
