package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

//@Component
public class RestTemplateRestRunner implements ApplicationRunner{
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	private String HOST_URL = "http://admin.mobideep.co.kr:8080";
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		RestTemplate build = restTemplateBuilder.build();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// get
		String helloResult = build.getForObject("http://localhost:8080/hello", String.class);
		
		System.out.println(helloResult);
		
		String worldResult = build.getForObject("http://localhost:8080/world", String.class);
		System.out.println(worldResult);
		
		
		// post 
		String credentialsId = "credentialsId";
		String resourceLoc = String.format("/api/v1/%s/attributes", credentialsId);

		String jsonStr = "{\"key\":\"value\"}";
		RestTemplate restTemplate = restTemplateBuilder.build();
		String reqUrl = String.format("%s%s", HOST_URL, resourceLoc);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(jsonStr, headers);
		String answer = restTemplate.postForObject(reqUrl, entity, String.class);
		
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
		
	}
	
	
	

}
