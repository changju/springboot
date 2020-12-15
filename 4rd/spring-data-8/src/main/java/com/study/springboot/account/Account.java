package com.study.springboot.account;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NodeEntity
public class Account {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	private String username;
	private String email;
	
}
