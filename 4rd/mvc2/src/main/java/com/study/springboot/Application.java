package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*
[32. 스프링 웹 MVC 4부: 정적 리소스 지원]
  정적 리소스 맵핑 “/**”
  리소스의 기본 맵핑은 root 부터 되어있다.
    기본 리소스 위치
      classpath:/static
      classpath:/public
      classpath:/resources/
      classpath:/META-INF/resources
      예) “/hello.html” => /static/hello.html
      spring.mvc.static-path-pattern: 맵핑 설정 변경 가능
        - spring.mvc.static-path-pattern=/resource/**
      spring.mvc.static-locations: 리소스 찾을 위치 변경 가능, 이것을 쓰면 위의 classpath가 모두 오버라이딩 된다.
      
  Last-Modified 헤더를 보고 304 응답을 보냄.
  ResourceHttpRequestHandler가 처리함.
      WebMvcConfigurer의 addRersourceHandlers로 커스터마이징 할 수 있음 (*추천*)

  -- 커스터마이징 code --
  WebMvcConfigurer 를 implements 하고 아래 함수를 오버라이딩 하여 추가한다.
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("/m/**")
             .addResourceLocations("classpath:/m/")
             .setCachePeriod(20);

  -- 실행 --
   springboot 실행 후 http://localhost:8080/m/hello.html 
*/

/*
 *
[36. 스프링 웹 MVC 5부: 웹JAR]
    웹JAR 맵핑 “/webjars/**” 
      버전 생략하고 사용하려면
        webjars-locator-core 의존성 추가 후 아래 3.5.1 생략이 가능하다.
    <script src="/webjars/bower/jquery/3.5.1/jquery.min.js"></script>
    <script>
       $(function() {
           console.log("ready!");
       });
    </script>

*/
/*
[37. 스프링 웹 MVC 6부: index 페이지와 파비콘]
    - 웰컴 페이지 ( 기본 리소스 위치(위 참조) 를 찾아 아래 index.html 을 웰컴 페이지로 처리한다)
        http://localhost:8080/ 를(루트 페이지) 요청 하면     
          - index.html 찾아 보고 있으면 제공.
          - index.템플릿 찾아 보고 있으면 제공.
          - 둘 다 없으면 에러 페이지.

    - 파비콘 ( classpath:/static 에 favicon.icon 을 복사해 놓는다. )
        favicon.ico
        파이콘 만들기 https://favicon.io/
        파비콘이 안 바뀔 때?
          - https://stackoverflow.com/questions/2208933/how-do-i-force-a-favicon-refresh
 * 
 * */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

}
