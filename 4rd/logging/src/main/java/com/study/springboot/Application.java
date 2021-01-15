package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
[24. 로깅 1부: 스프링 부트 기본 로거 설정]
  로깅 퍼사드 VS 로거
    Commons Logging, SLF4j
    JUL, Log4J2, Logback
  스프링 5에 로거 관련 변경 사항
    https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/overview.html#overview-logging
    Spring-JCL
        Commons Logging -> SLF4j or Log4j2 로 자동으로 변경 됨.
        pom.xml에 exclusion 안해도 됨.
  스프링 부트 로깅
    기본 포맷
    --debug (일부 핵심 라이브러리만 디버깅 모드로)
    --trace (전부 다 디버깅 모드로)
    컬러 출력: spring.output.ansi.enabled
    파일 출력: logging.file 또는 logging.path
    로그 레벨 조정: logging.level.패지키 = 로그 레벨


[25. 로깅 2부: 커스터마이징]
  https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html

  커스텀 로그 설정 파일 사용하기
    Logback: logback-spring.xml (이것으로 사용을 추천)
    Log4J2: log4j2-spring.xml
    JUL (비추): logging.properties
    Logback extension
        프로파일 <springProfile name=”프로파일”>
        Environment 프로퍼티 <springProperty>

    로거를 Log4j2로 변경하기
        https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html#howto-configure-log4j-for-logging
 * */
/* [설명]
 * Springboot는 기본적으로 Commons Logging 을 사용하며 결국에는 SLF4j 를 사용하게 된다.
 * Commons Logging와 SLF4j는 Logger api를 추상화 해 놓은 인터페이스들이다.
 * 실제 impl은 JUL(java utility log), Log4J2, Logback 이 있다.
 * 스프링 5부터 로거 관련 변경사항이있음
 *   Spring-JCL 을 사용하게 되면 Commons Logging을 SLF4j or Log4j2 를 사용하게 된다.
 *   Commons Logging > SLF4j or Log4j2 > Logback 으로 사용하게 된다.
 *   스프링 5 미만의 버전에서 SLF4j를 사용하기 위해서 exclusion 했어야 했지만, 스프링 5부터는 pom.xml에 exclusion 안해되 된다.
 * 많은 로그를 출력하기 위해서는 
 *  debug 사용 하며 (embedded container, Hibernate, Spring Boot) 만 해당 된다.
 *    program argument : --debug  
 *    vm(jvm) options : -Ddebug   
 *  debug 뿐만 아니라 모든 로그 출력을 하고 싶다면 : --trace 
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
