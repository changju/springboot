package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
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


// java -jar target/xxx.jar --spring.profiles.active=prod 와 같이하면 우선순위가 application.properties 보다 높기 때문에 커맨드 라인에서 입력한 값이 적용이 된다.
// 기본적인 application.properties 에 커맨드 라인으로 부터 설정 된 혹은 active={xx} 로 설정된 값에 따라 읽어들이는 값이 달라진다.

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);

	}

}
