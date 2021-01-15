package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
[47. 스프링 데이터 8부: 데이터베이스 마이그레이션]
  Flyway와 Liquibase가 대표적인데, 지금은 Flyway를 사용하겠습니다.

  https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup

  - 의존성 추가
      org.flywaydb:flyway-core

  - 마이그레이션 디렉토리
      db/migration 또는 db/migration/{vendor}
      spring.flyway.locations로 변경 가능

  - 마이그레이션 파일 이름
      V숫자__이름.sql
      V는 꼭 대문자로.
      숫자는 순차적으로 (타임스탬프 권장)
      숫자와 이름 사이에 언더바 두 개.
      이름은 가능한 서술적으로.
      
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
