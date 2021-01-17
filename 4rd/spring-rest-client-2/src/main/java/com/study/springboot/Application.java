package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient.Builder;

/*
[55. 스프링 REST 클라이언트 2부: 커스터마이징 ]
 - RestTemplate
    기본으로 java.net.HttpURLConnection 사용.
    커스터마이징
       로컬 커스터마이징
       글로벌 커스터마이징
         RestTemplateCustomizer
         빈 재정의

  - WebClient
      기본으로 Reactor Netty의 HTTP 클라이언트 사용.
      커스터마이징
         로컬 커스터마이징
         글로벌 커스터마이징
         WebClientCustomizer
         빈 재정의
*/
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}

	// 전역적으로 생성
	@Bean
	public WebClientCustomizer webClientCustomizer() {
		/*
		return new WebClientCustomizer() {
			@Override
			public void customize(Builder webClientBuilder) {
				webClientBuilder.baseUrl("http://localhost:8080");
			}
		};
		*/
		return s -> s.baseUrl("http://localhost:8080");
	}
	
	// apache http 로 수행하도록 설
	@Bean
	public RestTemplateCustomizer restTemplateCustomizer() {
		/*
		return new RestTemplateCustomizer() {
			@Override
			public void customize(RestTemplate restTemplate) {
				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
				
			}
		};
		*/
		return restTemplate -> restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	}


}
