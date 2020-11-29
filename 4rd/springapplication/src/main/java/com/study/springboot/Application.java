package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 @SpringBootApplication
 * 빈은 사실 두 단계로 나눠서 읽힘
  1단계: @ComponentScan
  2단계: @EnableAutoConfiguration
  @ComponentScan (@Component annotation 을 bean으로 등록)
    @Component
	 @Configuration @Repository @Service @Controller @RestController
  @EnableAutoConfiguration
	- spring.factories (meta file)
	   org.springframework.boot.autoconfigure.EnableAutoConfiguration 의 키 값 아래에 있는 조건의 bean을 등록한다.	    
    - @Configuration
	- @ConditionalOnXxxYyyZzz

@SpringBootConfiguration
@ComponentScan 
@EnableAutoConfiguration
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication app =new SpringApplication(Application.class);
		app.addListeners(new StartingListener());
		app.run(args);
		

	}

}
