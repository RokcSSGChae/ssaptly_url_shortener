package com.ssaptly.dao.stmt;

public class UrlMappingSQLStatements {
	public static final String findNoByOriginUrl = "SELECT NO FROM URL_MAPPING WHERE ORIGIN_URL = ?";
	public static final String findOriginUrlByShortUrl = "SELECT ORIGIN_URL FROM URL_MAPPING WHERE SHORT_URL = ?";
	public static final String findShortUrlByOriginUrl = "SELECT SHORT_URL FROM URL_MAPPING WHERE ORIGIN_URL = ?";
	public static final String addUrlMappingByOriginUrl = "INSERT INTO URL_MAPPING(NO, ORIGIN_URL, SHORTEN_DATE) VALUES(URL_MAPPING_SEQ.NEXTVAL, ?, SYSDATE)";
	public static final String updateShortUrl = "UPDATE URL_MAPPING SET SHORT_URL = ? WHERE NO = ?";
}
