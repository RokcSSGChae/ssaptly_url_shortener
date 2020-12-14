package com.ssaptly.utils;

public class UrlParser {
	private static final String HTTP_PREFIX = "http://";
	private static final String HTTPS_PREFIX = "https://";

	public static String tryToAddHttp(String url) {
		if (!url.startsWith(HTTP_PREFIX) && !url.startsWith(HTTPS_PREFIX)) {
			return HTTP_PREFIX + url;
		}
		return url;
	}
}
