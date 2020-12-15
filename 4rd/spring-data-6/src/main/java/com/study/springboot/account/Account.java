package com.study.springboot.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("accounts")
public class Account {
	
	@Id
	private String id;
	
	private String username;
	
	private String email;
}
