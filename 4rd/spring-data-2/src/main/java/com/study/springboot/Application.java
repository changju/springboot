package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*

[스프링 데이터 3부: MySQL]

 - 지원하는 DBCP (커넥션을 미리 만들어 놓고, 가져가서 사용하는 구조이다)
    HikariCP ( 스프링부트의 기본 DBCP이다 )
      https://github.com/brettwooldridge/HikariCP#frequently-used
    Tomcat CP
    Commons DBCP2

 - DBCP 설정
    spring.datasource.hikari.*
    spring.datasource.tomcat.*
    spring.datasource.dbcp2.*

 - MySQL 커넥터 의존성 추가
    <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
    </dependency>

 - MySQL 추가 (도커 사용)
    docker run -p 3306:3306 --name mysql_boot -e MYSQL_ROOT_PASSWORD=1 -e MYSQL_DATABASE=springboot -e MYSQL_USER=changjulee -e MYSQL_PASSWORD=pass -d mysql
    docker exec -i -t mysql_boot bash
    mysql -u root -p
    docker exec -it mysql_boot /usr/bin/mysql -u changjulee -p
 - MySQL용 Datasource 설정
    spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useSSL=false
    spring.datasource.username=changjulee
    spring.datasource.password=pass
    
 - MySQL 접속시 에러
    MySQL 5.* 최신 버전 사용할 때 
  문제
    Sat Jul 21 11:17:59 PDT 2018 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification. 
  해결
    jdbc:mysql:/localhost:3306/springboot?useSSL=false

 - MySQL 8.* 최신 버전 사용할 때
  문제
    com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException: Public Key Retrieval is not allowed
  해결
    jdbc:mysql:/localhost:3306/springboot?useSSL=false&allowPublicKeyRetrieval=true

  - MySQL 라이센스 (GPL) 주의
    MySQL 대신 MariaDB 사용 검토
    소스 코드 공개 의무 여부 확인
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
