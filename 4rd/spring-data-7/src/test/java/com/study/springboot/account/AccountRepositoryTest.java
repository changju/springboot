package com.study.springboot.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest // Mongo 관련 bean 만 등록이 되어진다. (mock bean 으로 등록이 되어진다)
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void findByEmail() {
		Account account = new Account();
		account.setUsername("changjulee3");
		account.setEmail("gulgulriju3@gmail.com");
		
		accountRepository.save(account);
		
		Optional<Account> byId = accountRepository.findById(account.getId());
		assertThat(byId).isNotEmpty();
		
		Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
		assertThat(byEmail).isNotEmpty();
		assertThat(byEmail.get().getUsername()).isEqualTo("changjulee3");
		

	}

}
