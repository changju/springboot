package com.study.springboot;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.study.springboot.account.Account;

public class Neo4jRunner implements ApplicationRunner{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account account = new Account();
		account.setEmail("gulgulriju@gmail.com");
		account.setUsername("changjulee");
		
		Session session = sessionFactory.openSession();
		session.save(account);
		sessionFactory.close();
		
		System.out.println("finished!");
	}
}
