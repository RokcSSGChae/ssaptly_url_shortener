package com.ssaptly.utils;

public class UrlConverter {
	private static final String HTTP_PREFIX = "http://";
	private static final String HTTPS_PREFIX = "https://";
	private static final String DOMAIN_PREFIX = "http://localhost:8888/";

	public static String convertUrlWithHttp(String url) {
		if (!url.startsWith(HTTP_PREFIX) && !url.startsWith(HTTPS_PREFIX)) {
			return HTTP_PREFIX + url;
		}
		return url;
	}
	
	public static String convertShortUrlWithDomain(String url) {
		return DOMAIN_PREFIX + url;
	}
}
