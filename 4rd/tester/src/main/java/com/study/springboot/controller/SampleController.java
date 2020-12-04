package com.study.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.service.SampleService;

@RestController
public class SampleController {

	Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;
	
	@GetMapping("/hello")
	public String hello() {
		logger.info("changju hello");
		System.out.println("skip");
		return "hello " + sampleService.getName();
	}
}
