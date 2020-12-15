package com.study.springboot.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// 리턴 타입으로 Optional 로 할 수 있다.
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}