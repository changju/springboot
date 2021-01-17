package com.study.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 특정한 요청이 들어올때 특정한 View 로만 보내면 된다 라 할 때 아래 방법을 사용한다.
@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hells").setViewName("hellos");
	}
}
