package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 * 

[SpringApplication 1부] * 이것은 왠 넣지 않은 듯 함.
 - 기본 로그 레벨 INFO
 - FailureAnalyzer
 - 배너
    banner.txt | gif | jpg | png
    classpath 또는 spring.banner.location
    ${spring-boot.version} 등의 변수를 사용할 수 있음.
    Banner 클래스 구현하고 SpringApplication.setBanner()로 설정 가능.
    배너 끄는 방법
  - SpringApplicationBuilder로 빌더 패턴 사용 가능


[SpringApplication 2부]
 - ApplicationEvent 등록
      ApplicationContext를 만들기 전에 사용하는 리스너는 @Bean으로 등록할 수 없다.
         SpringApplication.addListners()
 - WebApplicationType 설정
 - 애플리케이션 아규먼트 사용하기
      ApplicationArguments를 빈으로 등록해 주니까 가져다 쓰면 됨.
 -  애플리케이션 실행한 뒤 뭔가 실행하고 싶을 때
      ApplicationRunner (추천) 또는 CommandLineRunner
      순서 지정 가능 @Order
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
