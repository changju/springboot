package com.study.springboot.account;


import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NodeEntity
public class Account {
	
	@Id  // Neo4j에서 @Id는 숫자타입 에만 쓸 수 있다. 
	@GeneratedValue
	private Long id;
	
	private String username;
	private String email;
	
	@Relationship(type = "has")
	private Set<Role> roles = new HashSet<>();
}
