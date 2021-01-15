package com.study.springboot.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// collection 은 rdb 에서 table을 뜻한다.
@Document(collection = "accounts")
public class Account {
	@Id
	private String id;
	private String username;
	private String email;
	
	
}
