package com.study.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 주로 이 방법을 추천한다.
@Configuration
public class WebConfig implements WebMvcConfigurer {

	// * 스프링 부트가 제공하는 기존 리소스핸들러는 그대로 유지하면서, 내가 원하는 핸들러만 추가가 가능하다.
	// GET /hello.html 기본 리소스 핸들러에서 제공하는 것인데 이것은 그대로 유지한다. 
	// GET /m/hello.html 는 추가 되었고 /m/ "resource 경로"를 바라보게 된다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/m/**") // m 이 후 모든 resource
		        .addResourceLocations("classpath:/m/") // * 반드시 문자열의 마지막이 "/" 로 끝나야 한다.
		        .setCachePeriod(20);
		

	}
}
