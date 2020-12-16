package com.ssaptly.utils;

import org.apache.commons.validator.routines.UrlValidator;

public class UrlMappingValidator {
	private static final String[] SCHEMES = new String[] { "http", "https" };

	public static boolean isValid(String url) {
		UrlValidator urlValidator = new UrlValidator(SCHEMES);
		if (urlValidator.isValid(url)) {
			return true;
		}
		return false;
	}
}
