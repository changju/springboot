package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	/*
	 * Spring Security 가 만들어준 로그인 폼으로 자동으로 띄워진다. 
	 * */
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/my")
	public String my() {
		return "my";
	}
}
