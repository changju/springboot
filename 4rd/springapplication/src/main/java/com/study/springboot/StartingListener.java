package com.study.springboot;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component 는 쓰질 못한다. 아무것도 설정이 안된 상태에서 하기 때문에.
//listener 로 등록 후 사용해야 한다. ( ApplicationContext를 만들기 전에 사용하는 리스너는 @Bean으로 등록할 수 없다.)
public class StartingListener implements ApplicationListener<ApplicationStartingEvent>{

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("===================");
		System.out.println("application is starting");
		System.out.println("===================");
		
	}

}
