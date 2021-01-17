package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.study.springboot.account.Account;
import com.study.springboot.account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Component
public class AccountRunner implements ApplicationRunner {

	@Autowired
	AccountService accountService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account account = accountService.createAccount("cjlee", "1234");
		System.out.println(account.toString());
		
	}
}
