package com.study.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//registry.addMapping("/hello")
		registry.addMapping("/**") // 모든것을 공개하겠다.
		.allowedOrigins("http://localhost:18080");		
	}
}
