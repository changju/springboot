package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PrettyFatherRunner implements ApplicationRunner{

	@Autowired
	PrettyFather prettyFather;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(prettyFather);
	}

	
}
