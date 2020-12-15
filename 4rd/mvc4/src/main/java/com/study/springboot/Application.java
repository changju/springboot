package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
    스프링 웹 MVC 9부: ExceptionHandler
      스프링 @MVC 예외 처리 방법
        @ControllerAdvice
        @ExchangepHandler

    스프링 부트가 제공하는 기본 예외 처리기
      BasicErrorController
        HTML과 JSON 응답 지원
          @RequestMapping("${server.error.path:${error.path:/error}}")
          class BasicErrorController {...}
            위 @RequestMapping 의미는 if else else.. 이다.
              1. server.error.path
              2. error.path
              3. /error
              
      커스터마이징 방법
        ErrorController 구현

    커스텀 에러 페이지
      상태 코드 값에 따라 에러 페이지 보여주기
        src/main/resources/static|template/error/
          404.html
          5xx.html
      ErrorViewResolver 구현
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
