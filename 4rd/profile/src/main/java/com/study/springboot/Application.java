package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 * 
[23  프로파일]

  @Profile 애노테이션은 어디에?
    @Configuration
    @Component
  어떤 프로파일을 활성화 할 것인가?
    spring.profiles.active
  어떤 프로파일을 추가할 것인가?
    spring.profiles.include
  프로파일용 프로퍼티
    application-{profile}.properties

// java -jar target/xxx.jar --spring.profiles.active=prod 와 같이하면 우선순위가 application.properties 보다 높기 때문에 커맨드 라인에서 입력한 값이 적용이 된다.
// 기본적인 application.properties 에 커맨드 라인으로 부터 설정 된 혹은 active={xx} 로 설정된 값에 따라 읽어들이는 값이 달라진다.
 * 
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);

	}

}
