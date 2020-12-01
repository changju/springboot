package com.study.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//application.properties 의 spring.profiles.active 의 항목에 따라 어떤것 읽을지 알려준다.
// 설정이 없다면 bean - hello를 찾지를 못한다.
@Profile("prod")
@Configuration
public class BaseConfiguration {
	
	@Bean
	public String hello() {
		return "hello BaseConfiguration";
	}
	
}
