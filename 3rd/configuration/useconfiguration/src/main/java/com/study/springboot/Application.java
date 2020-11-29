package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
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
		SpringApplication application = new SpringApplication(Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}
	
	/*
	 * ComponentScan 으로 Bean으로 등록이 된다.
	 * EnableAutoConfiguration 에서 등록을 하기 때문에  오버라이드 된다.
	 * @ConditionalOnMissingBean 가 정의가 안되어 있다면, 내가 정의한 bean은 사용 할 수 없다.
	@Bean
	public PrettyFather prettyFather()
	{
		PrettyFather prettyFather =  new PrettyFather();
		prettyFather.setName("cblee");
		prettyFather.setOld(29);
		return prettyFather;
	}
	*/
	
}
