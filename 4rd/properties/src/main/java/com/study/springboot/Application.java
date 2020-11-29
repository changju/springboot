package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


//@EnableConfigurationProperties 가 있어야 bean으로 등록을 해주고 meta 정보에서 값 을 넣어준다.
//@EnableConfigurationProperties(PropertiesRef2.class)
//하지만, @EnableConfigurationProperties 는 bean으로 등록되어 있기 때문에
// PropertiesRef2 에서 component에서 bean으로 등록을 하면 된다.
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}
}
