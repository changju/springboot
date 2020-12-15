package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*

[스프링 데이터 1부: 소개]
[SQL DB]
  NoSQL
  인메모리 데이터베이스 지원
  DataSource 설정
  DBCP 설정
  JDBC 사용하기
  스프링 데이터 JPA 사용하기
  jOOQ 사용하기
  데이터베이스 초기화
  데이터베이스 마이그레이션 툴 연동하기

 [NO SQL]
   Redis (Key/Value)
   MongoDB (Document)
   Neo4J (Graph)
   Gemfire (IMDG) --  생략 
   Solr (Search) --  생략 
   Elasticsearch (Search & Analytics) --  생략 
   Cassandra --  생략 
   Couchbase --  생략 
   LDAP --  생략
   InfluxDB --  생략 

------------------------------------------------------------

[스프링 데이터 2부: 인메모리 데이터베이스]

- 지원하는 인-메모리 데이터베이스
   H2 (추천, 콘솔 때문에...)
   HSQL
   Derby

- Spring-JDBC가 클래스패스에 있으면 자동 설정이 필요한 빈을 설정 해줍니다.
   DataSource 
   JdbcTemplate

- 인-메모리 데이터베이스 기본 연결 정보 확인하는 방법
   URL: “testdb”
   username: “sa”
   password: “”

- H2 콘솔 사용하는 방법
   spring-boot-devtools를 추가하거나...
   spring.h2.console.enabled=true 만 추가.
   /h2-console로 접속 (이 path도 바꿀 수 있음)

- 실습 코드
   CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))
   INSERT INTO USER VALUES (1, ‘keesun’)


 * */
//pom.xml 에 의존성만 설정을 해주더라도 인메모리 db 가 설정이 되어 메모리에 올린다.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
