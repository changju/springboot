package com.study.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// ArgumentListener을 bean 으로 등록을 하면서 생성자가 하나이면서
// 그 생성자의 파라미터가 bean 일 경우 spring이 알아서 주입을 해준다.
// @Component의 의미는 ApplicationContext 에 Bean을 등록을 하는데 등록을 하면서 생성자가 호출이 되어진다.
@Component
public class ArgumentListener {

	public ArgumentListener(ApplicationArguments arguments) {
		System.out.println("==========ArgumentListener==========");
		System.out.println("foo: " + arguments.containsOption("foo"));
		System.out.println("bar: " + arguments.containsOption("bar"));
		System.out.println("========================================");
	}
}