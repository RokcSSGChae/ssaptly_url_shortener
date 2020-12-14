package com.ssaptly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlMappingController {

	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
}