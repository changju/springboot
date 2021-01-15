package com.study.springboot.account;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NodeEntity
public class Role {
	
	@Id  // Neo4j에서 @Id는 숫자타입 에만 쓸 수 있다. 
	@GeneratedValue
	private Long id;
	
	private String name;
}
