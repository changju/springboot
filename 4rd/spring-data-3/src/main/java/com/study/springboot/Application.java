package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
[43. 스프링 데이터 4부: PostgreSQL]

 - 의존성 추가
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
    </dependency>

 - PostgreSQL 설치 및 서버 실행 (docker)
    docker run -p 5432:5432 -e POSTGRES_PASSWORD=pass -e POSTGRES_USER=changjulee -e POSTGRES_DB=springboot --name postgres_boot -d postgres
    docker exec -i -t postgres_boot bash
    su - postgres
    psql springboot

    데이터베이스 조회
      \list

    테이블 조회
      \dt

    쿼리
      SELECT * FROM account;

  - PostgreSQL 경고 메시지

    경고
      org.postgresql.jdbc.PgConnection.createClob() is not yet implemented
    해결
      spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
 * */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
