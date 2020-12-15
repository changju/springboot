package com.study.springboot.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@PostMapping("/users/create")
	public User create2(@RequestBody User user) {
		return user;
	}

	
	/*
	 * 객체를 변환하여 응답으로 전달한다 HttpMessageConverter 이며, 기본으로 JsonMessageConverter 을 사용한다. 
	 * @RestController를 사용했다면, @ResponseBody는 생략해도 괜찮다.
	 * @Controller 이면서 @ResponseBody 가 없다면 ViewResover는 View를 찾게 된다.
	 */
	@PostMapping("/users")
	public @ResponseBody User create1(@RequestBody User user) {
		return null;
	}
}
