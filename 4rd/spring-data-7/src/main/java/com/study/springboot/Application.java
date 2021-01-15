package com.study.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.study.springboot.account.Account;
import com.study.springboot.account.AccountRepository;

/*
[49. 스프링 데이터 10부: MongoDB]
 - MongoDB는 JSON 기반의 도큐먼트 데이터베이스입니다.

 - 의존성 추가
    spring-boot-starter-data-mongodb

 - MongoDB 설치 및 실행 (도커)
    1. docker run -p 27017:27017 --name mongo_boot -d mongo
    2. docker exec -i -t mongo_boot bash
    3. mongo
    4. db
    5. use test
    6. db.accounts.find({})
    
 - 스프링 데이터 몽고DB
    MongoTemplate
    MongoRepository
    내장형 MongoDB (테스트용)
    de.flapdoodle.embed:de.flapdoodle.embed.mongo
    @DataMongoTest
 * */

@SpringBootApplication
public class Application {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);

	}
/*
	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {

			@Override
			public void run(ApplicationArguments args) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
*/	
	@Bean
	public ApplicationRunner applicationRunner() {
		
		return args -> {
			Account account = new Account();
			account.setEmail("gulgulriju@gmail.com");
			account.setUsername("changejulee");
			mongoTemplate.insert(account);
			
			Account account2 = new Account();
			account2.setEmail("gulgulriju2@gmail.com");
			account2.setUsername("changejulee2");
			accountRepository.save(account2);
			
			Optional<Account> oAccount = accountRepository.findByEmail("gulgulriju2@gmail.com");
			oAccount.ifPresent(c ->{
				System.out.println(c.toString());
			});
			
			System.out.println("finished");
		};
		
	}

}
