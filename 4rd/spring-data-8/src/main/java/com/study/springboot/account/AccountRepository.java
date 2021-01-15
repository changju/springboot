package com.study.springboot.account;


import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface AccountRepository extends Neo4jRepository<Account, Long> {
	
	
}
