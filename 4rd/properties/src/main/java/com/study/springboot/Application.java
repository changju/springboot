package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
/*
 * 
 *
[21. 외부 설정 1부]
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config

사용할 수 있는 외부 설정
   properties
   YAML
   환경 변수
   커맨드 라인 아규먼트

프로퍼티 우선 순위
   유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
   테스트에 있는 @TestPropertySource
   @SpringBootTest 애노테이션의 properties 애트리뷰트
   커맨드 라인 아규먼트
   SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티
   ServletConfig 파라미터
   ServletContext 파라미터
   java:comp/env JNDI 애트리뷰트
   System.getProperties() 자바 시스템 프로퍼티
   OS 환경 변수
   RandomValuePropertySource
   JAR 밖에 있는 특정 프로파일용 application properties
   JAR 안에 있는 특정 프로파일용 application properties
   JAR 밖에 있는 application properties
   JAR 안에 있는 application properties
   @PropertySource
   기본 프로퍼티 (SpringApplication.setDefaultProperties)

application.properties 우선 순위 (높은게 낮은걸 덮어 씁니다.)
   file:./config/
   file:./
   classpath:/config/
   classpath:/

랜덤값 설정하기
   ${random.*}

플레이스 홀더
   name = keesun
   fullName = ${name} baik

----------------------------------------------------------------------
----------------------------------------------------------------------

[외부 설정 2부]

타입-세이프 프로퍼티 @ConfigurationProperties
  여러 프로퍼티를 묶어서 읽어올 수 있음
  빈으로 등록해서 다른 빈에 주입할 수 있음
    @EnableConfigurationProperties
    @Component
    @Bean
  융통성 있는 바인딩
    context-path (케밥)
    context_path (언드스코어)
    contextPath (캐멀)
    CONTEXTPATH
  프로퍼티 타입 컨버전
    @DurationUnit
  프로퍼티 값 검증
    @Validated
    JSR-303 (@NotNull, ...)
  메타 정보 생성
  @Value
    SpEL 을 사용할 수 있지만...
    위에 있는 기능들은 전부 사용 못합니다.

 * */

//@EnableConfigurationProperties 가 있어야 bean으로 등록을 해주고 meta 정보에서 값 을 넣어준다.
//@EnableConfigurationProperties(PropertiesRef2.class)
//하지만, @EnableConfigurationProperties 는 이미 bean으로 등록되어 있기 때문에
// PropertiesRef2 에서 component에서 bean으로 등록을 하면 된다.
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}
}
