package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/* desc
 * Springboot는 기본적으로 Commons Logging 을 사용하며 결국에는 SLF4j 를 사용하게 된다.
 * Commons Logging와 SLF4j는 Logger api를 추상화 해 놓은 인터페이스들이다.
 * 실제 impl은 JUL(java utility log), Log4J2, Logback 이 있다.
 * 스프링 5부터 로거 관련 변경사항이있음
 *   Spring-JCL 을 사용하게 되면 Commons Logging을 SLF4j or Log4j2 를 사용하게 된다.
 *   Commons Logging > SLF4j or Log4j2 > Logback 으로 사용하게 된다.
 *   스프링 5 미만의 버전에서 SLF4j를 사용하기 위해서 exclusion 했어야 했지만, 스프링 5부터는 pom.xml에 exclusion 안해되 된다.
 * 많은 로그를 출력하기 위해서는 
 *  program argument : --debug  
 *  vm options : -Ddebug   
 *  모든 로그 출력 : --trace
 *  spring.output.ansi.enabled 로 컬러에 대한 설
 *  logging.file: 로그의 파일 설정 
 *  logging.path: 로그의 디렉토리 설정 
 *  logging.level.xxx.xxx... : log package 설정 
 *  --------------------------------------------
 *  커스텀 로그 설정 파일 사용
 *    Logback 사용시 : logback-spring.xml
 *    Log4J2 사용시 : log4j2-spring.xml
 * */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
		
	}
}
