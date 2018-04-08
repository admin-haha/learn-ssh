package com.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	Logger logger = LoggerFactory.getLogger(Test.class);
	
	@RequestMapping("/test")
	public String test() {
		
		logger.info("hahah");
		return "Test!";
	}
}
