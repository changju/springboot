package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
  스프링 웹 MVC 7부: Thymeleaf

    스프링 부트가 자동 설정을 지원하는 템플릿 엔진 (주로 view 를 만드는데 사용을 한다.)
      Thymeleaf (비교적 최근에 만들어진 템플릿 엔진이다)
      FreeMarker
      Groovy
      Mustache

    JSP를 권장하지 않는 이유
     JAR 패키징 할 때는 동작하지 않고, WAR 패키징 해야 함.
     Undertow는 JSP를 지원하지 않음.
     https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations

    Thymeleaf 사용하기 ( view 의 렌더링 결과를 쉽게 알 수 있다. )
     https://www.thymeleaf.org/
     https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html
     의존성 추가: spring-boot-starter-thymeleaf
     템플릿 파일 위치: /src/main/resources/template/
     
     예제: https://github.com/thymeleaf/thymeleafexamples-stsm/blob/3.0-master/src/main/webapp/WEB-INF/templates/seedstartermng.html
       - html에  namespace 가 반드시 추가되어야 한다. 
         - <html xmlns:th="http://www.thymeleaf.org"> 를 추가시켜줘야 한다.
 * */
/*
 * 
  스프링 웹 MVC 8부: HtmlUnit ( 이 의존성은 test scope이다. )
   
  HTML 템플릿 뷰 테스트를 보다 전문적으로 하자.
    http://htmlunit.sourceforge.net/
    http://htmlunit.sourceforge.net/gettingStarted.html
    의존성 추가

  <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>htmlunit-driver</artifactId>
     <scope>test</scope>
  </dependency>
  <dependency>
     <groupId>net.sourceforge.htmlunit</groupId>
     <artifactId>htmlunit</artifactId>
     <scope>test</scope>
  </dependency>

    @Autowire WebClient 
 * */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
