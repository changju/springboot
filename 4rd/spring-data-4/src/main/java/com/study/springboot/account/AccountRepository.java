package com.study.springboot.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 리턴 타입으로 Optional 로 할 수 있다.
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	//jpql 이 기본이다. 
	////@Query(nativeQuery = true, value = "select * from account where username = '{0}'")
	Optional<Account> findByUsername(String username);
}