package com.study.springboot;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


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
