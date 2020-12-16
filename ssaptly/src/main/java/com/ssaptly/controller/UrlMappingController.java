package com.ssaptly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.ssaptly.biz.UrlMappingBIZ;

@Controller
public class UrlMappingController {

	@Autowired
	UrlMappingBIZ urlMappingBIZ;
	
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	@RequestMapping(path="/{shortUrl:\\w+}", method = RequestMethod.GET)
	public RedirectView redirect(@PathVariable String shortUrl) {
		String originUrl = urlMappingBIZ.findOriginUrlByShortUrl(shortUrl);
		return new RedirectView(originUrl);
	}
}
