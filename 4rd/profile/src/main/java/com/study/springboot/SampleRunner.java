package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.study.springboot.properties.PropertiesRef;

@Component
public class SampleRunner implements ApplicationRunner{

	@Autowired
	private String hello;
	
	// java -jar target/jarname.jar --spring.profiles.active={xxx}  의 설정에 따라 (application-{xxx}.properties) 읽어들이는 값이 달라진다.
	@Autowired
	private PropertiesRef propertiesRef;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("======================");
		System.out.println(hello);
		System.out.println("======================");
		
		System.out.println("======================");
		System.out.println(propertiesRef.getName());
		System.out.println("======================");
		
		System.out.println("======================");
		System.out.println(propertiesRef.getProddb());
		System.out.println("======================");
		
	}

}
