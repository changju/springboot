package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
[스프링 웹 MVC 1부: 소개]

스프링 웹 MVC
  https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#spring-web
스프링 부트 MVC
  자동 설정으로 제공하는 여러 기본 기능 (앞으로 살펴볼 예정)
스프링 MVC 확장
  @Configuration + WebMvcConfigurer
스프링 MVC 재정의
  @Configuration + @EnableWebMvc (거의 사용하지 않음)
*/

/*
[스프링 웹 MVC 2부: HttpMessageConverters]

https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#mvc-config-message-converters

HTTP 요청 본문을 객체로 변경하거나, 객체를 HTTP 응답 본문으로 변경할 때 사용.
{“username”:”keesun”, “password”:”123”} <-> User
  @ReuqestBody
  @ResponseBody
*/

/*
[스프링 웹 MVC 3부: ViewResolver]

스프링 부트
  뷰 리졸버 설정 제공
  HttpMessageConvertersAutoConfiguration
 
XML 메시지 컨버터 추가하기

  <dependency>
     <groupId>com.fasterxml.jackson.dataformat</groupId>
     <artifactId>jackson-dataformat-xml</artifactId>
     <version>2.9.6</version>
  </dependency>
 * */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
