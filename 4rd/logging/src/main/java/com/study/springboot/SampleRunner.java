package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//application 이 모두 실행 후 추가적으로 실행하고 싶을 경우.
@Component
public class SampleRunner implements ApplicationRunner{

	private Logger logger = LoggerFactory.getLogger(SampleRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("==============info SampleRunner====================");
		logger.debug("==============debug SampleRunner====================");
	}

}
