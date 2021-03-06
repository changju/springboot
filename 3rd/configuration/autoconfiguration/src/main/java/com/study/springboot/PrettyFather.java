package com.study.springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 
 [자동 설정 만들기 1부: Starter와 Autoconfigure]

https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-developing-auto-configuration

  Xxx-Spring-Boot-Autoconfigure 모듈: 자동 설정
  Xxx-Spring-Boot-Starter 모듈: 필요한 의존성 정의
  그냥 하나로 만들고 싶을 때는?
    Xxx-Spring-Boot-Starter
  구현 방법
    의존성 추가
-----------------------------------
<dependencies>
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-autoconfigure</artifactId>
   </dependency>
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-autoconfigure-processor</artifactId>
       <optional>true</optional>
   </dependency>
</dependencies>

<dependencyManagement>
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-dependencies</artifactId>
           <version>2.0.3.RELEASE</version>
           <type>pom</type>
           <scope>import</scope>
       </dependency>
   </dependencies>
</dependencyManagement>
-----------------------------------


  @Configuration 파일 작성
  src/main/resource/META-INF에 spring.factories 파일 만들기
  spring.factories 안에 자동 설정 파일 추가
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    FQCN,\
    FQCN
  mvn install


[자동 설정 만들기 2부: @ConfigurationProperties]
 - 덮어쓰기 방지하기
    @ConditionalOnMissingBean

- 빈 재정의 수고 덜기
    @ConfigurationProperties(“holoman”)
    @EnableConfigurationProperties(HolomanProperties)
    프로퍼티 키값 자동 완성

------------------------------------
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-configuration-processor</artifactId>
   <optional>true</optional>
</dependency>
------------------------------------


 * 
 * */
@Getter
@Setter
@ToString
public class PrettyFather {
	String name;
	int old;
	
}
