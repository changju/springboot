package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
5부: 스프링 부트 운영
스프링 부트는 애플리케이션 운영 환경에서 유용한 기능을 제공합니다. 스프링 부트가 제공하는 엔드포인트와 메트릭스 그리고 그 데이터를 활용하는 모니터링 기능에 대해 학습합니다.
[57. 스프링 부트 Actuator 1부: 소개]
  - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints

  - 의존성 추가
    spring-boot-starter-actuator

  - 애플리케이션의 각종 정보를 확인할 수 있는 Endpoints
      다양한 Endpoints 제공.
      JMX 또는 HTTP를 통해 접근 가능 함.
      shutdown을 제외한 모든 Endpoint는 기본적으로 활성화 상태.
      활성화 옵션 조정
        management.endpoints.enabled-by-default=false
        management.endpoint.info.enabled=true
        
 [58. 스프링 부트 Actuator 2부: JMX와 HTTP]

  - JConsole 사용하기
      https://docs.oracle.com/javase/tutorial/jmx/mbeans/
      https://docs.oracle.com/javase/7/docs/technotes/guides/management/jconsole.html


  - VisualVM 사용하기
      https://visualvm.github.io/download.html

  - HTTP 사용하기
      /actuator
      health와 info를 제외한 대부분의 Endpoint가 기본적으로 비공개 상태
      공개 옵션 조정
        management.endpoints.web.exposure.include=*
        management.endpoints.web.exposure.exclude=env,beans


 [59. 스프링 부트 Actuator 3부: Spring-Boot-Admin]
  https://github.com/codecentric/spring-boot-admin
  스프링 부트 Actuator UI 제공
 - 어드민 서버 설정
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-server</artifactId>
        <version>2.0.1</version>
    </dependency>

    @EnableAdminServer

 - 클라이언트 설정
    <dependency>
        <groupId>de.codecentric</groupId>
        <artifactId>spring-boot-admin-starter-client</artifactId>
        <version>2.0.1</version>
    </dependency>

    spring.boot.admin.client.url=http://localhost:8080
    management.endpoints.web.exposure.include=*
*/
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}











