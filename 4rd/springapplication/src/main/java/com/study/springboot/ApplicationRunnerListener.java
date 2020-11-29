package com.study.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// application 이 모두 실행 후 추가적으로 실행하고 싶을 경우.
// commandLineRunner도 있지만 ApplicationRunner 가  좋음.
@Component
public class ApplicationRunnerListener implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("==========ApplicationRunnerListener==========");
		System.out.println("foo: " + args.containsOption("foo"));
		System.out.println("bar: "+ args.containsOption("bar"));
		System.out.println("========================================");
	}
}
