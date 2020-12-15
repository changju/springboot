package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
스프링 웹 MVC 11부: CORS

 - SOP과 CORS
    Single-Origin Policy
    Cross-Origin Resource Sharing
    Origin?
      URI 스키마 (http, https)
      hostname (whiteship.me, localhost)
      포트 (8080, 18080)

 - 스프링 MVC @CrossOrigin
    https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#mvc-cors
    @Controller나 @RequestMapping에 추가하거나
    WebMvcConfigurer 사용해서 글로벌 설정 

 * */
@SpringBootApplication
@RestController
public class Application {

	//특정 함수 혹은 클래스에 적용 할 수 있다.
	//@CrossOrigin(origins = "http://localhost:18080")
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
