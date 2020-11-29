package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerListener implements ApplicationRunner{

	@Autowired
	PropertiesRef1 properties1;
	
	@Autowired
	PropertiesRef2 properties2;
	
	// ServerProperties 는 이미 bean 으로 등록이 되어 있기 때문에
	// @Component 로 하여 bean 등록하지 못하기에 아래와 같이 할 수 있다.  
	@ConfigurationProperties("server")
	@Bean
	public ServerProperties serverProperties() {
		return new ServerProperties();
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("=======================");
		System.out.println(properties1.getName());
		System.out.println("=======================");
		
		//효율적으로 properties 값을 가져오기
		System.out.println("=======================");
		System.out.println(properties2.getName());
		System.out.println(properties2.getAge());
		System.out.println(properties2.getSessionTimeout());
		System.out.println("=======================");
		
	}

}
