package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.study.springboot.account.Account;
import com.study.springboot.account.AccountRepository;

//jpa 관련 bean 만 슬라이싱 하여 테스트 할 수 있다.
//슬라이싱 테스트 일 때는 inmemory db (h2)  를 추가해야 에러가 발생하지 않는다.
@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest //슬라이싱이 아닌 모든 빈들이 등록이 되어 테스트가 진행이 된다.
public class AccountRepositoryTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void di()throws SQLException{
		
		try (Connection connection = dataSource.getConnection()) {
			
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println(connection.getMetaData().getUserName());

			
		}
		
		Account account = new Account();
		account.setUsername("changbonglee");
		account.setPassword("pass");
		
		Account newAccount = accountRepository.save(account);
		assertThat(newAccount).isNotNull();
		
		Optional<Account> existingAccount1 = accountRepository.findByUsername(newAccount.getUsername());
		assertThat(existingAccount1).isNotEmpty();
		
		Optional<Account> existingAccount2 = accountRepository.findByUsername("changbonglee");
		assertThat(existingAccount2).isNotEmpty();
		
		Optional<Account> existingAccount3 = accountRepository.findByUsername("jiyoonlee");
		assertThat(existingAccount3).isEmpty();
		
		
		
	}
}
