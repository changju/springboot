package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
[스프링 데이터 11부: Neo4j]
 - Neo4j는 노드간의 연관 관계를 영속화하는데 유리한 그래프 데이터베이스 입니다. 

 - 의존성 추가
    spring-boot-starter-data-neo4j

 - Neo4j 설치 및 실행 (도커)
    docker run -p 7474:7474 -p 7687:7687 -d --name noe4j_boot neo4j
    http://localhost:7474/browser

 - 스프링 데이터 Neo4J
    Neo4jTemplate (Deprecated)
    SessionFactory
    Neo4jRepository

 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
