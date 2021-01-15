package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
[48. 스프링 데이터 9부: Redis]
- 캐시, 메시지 브로커, 키/밸류 스토어 등으로 사용 가능.

- 의존성 추가
   spring-boot-starter-data-redis

- Redis 설치 및 실행 (도커)
   docker run -p 6379:6379 --name redis_boot -d redis
   docker exec -i -t redis_boot redis-cli

- 스프링 데이터 Redis
   https://projects.spring.io/spring-data-redis/
   StringRedisTemplate 또는 RedisTemplate
   extends CrudRepository

- Redis 주요 커맨드
   https://redis.io/commands
   keys *
   get {key}
   hgetall {key}
   hget {key} {column}

- 커스터마이징
   spring.redis.*
   
- 간단한 redis 문
  keys *
  get hello
  hget hashcode email
  hgetall hashcode
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
