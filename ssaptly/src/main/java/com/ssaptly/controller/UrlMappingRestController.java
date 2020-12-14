package com.ssaptly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssaptly.biz.UrlMappingBIZ;
import com.ssaptly.utils.UrlMappingValidator;
import com.ssaptly.utils.UrlParser;

@RestController
@RequestMapping("/rest/url")
public class UrlMappingRestController {
	
	private static final String NOT_VALID_URL_MSG = "유효하지 않은 URL입니다.";

	@Autowired
	UrlMappingBIZ urlMappingBIZ;

	@RequestMapping(path = "/shorten", method = RequestMethod.POST)
	public String shortenUrl(@RequestParam(value = "url", required = true) String url) {
		if(!UrlMappingValidator.isValid(url)) {
			return NOT_VALID_URL_MSG;
		}
		return urlMappingBIZ.shortenUrl(UrlParser.tryToAddHttp(url));
	}
}
