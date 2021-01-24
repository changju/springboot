package com.study.springboot;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/* 아래 코드는 StartedListener 로 ApplicationListener<ApplicationStartedEvent> 를 구현하여 Bean 으로 등록을 하였다.
 * Spring framework 내에서 ApplicationListener<ApplicationStartedEvent> 의 Bean 이 등록이 되어 있는지 확인을 할 수 있다.
 * 등록이 되어 있다면 (아래 코드에서 등록을 한 상태) Autowired 를 통해 객체를 불러온 후 Override 함수를 호출하게 된다. 
 * */

@Component
public class StartedListener implements ApplicationListener<ApplicationStartedEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("===================");
		System.out.println("application is started");
		System.out.println("===================");	
	}
}
