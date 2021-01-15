package com.study.springboot;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.study.springboot.account.Account;
import com.study.springboot.account.AccountRepository;
import com.study.springboot.account.Role;

public class Neo4jRunner implements ApplicationRunner{

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account account = new Account();
		account.setEmail("gulgulriju@gmail.com");
		account.setUsername("changjulee");
		
		Role role = new Role();
		role.setName("admin");
		
		account.getRoles().add(role);
		
		Session session = sessionFactory.openSession();
		session.save(account);
		sessionFactory.close();
		
		// Repository 이용하기 
		Account account2 = new Account();
		account.setEmail("gulgulriju2@gmail.com");
		account.setUsername("changjulee2");
		accountRepository.save(account2);
		
		System.out.println("finished!");
	}
}