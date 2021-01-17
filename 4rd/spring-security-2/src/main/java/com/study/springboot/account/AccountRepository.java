package com.study.springboot.account;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.Getter;
import lombok.Setter;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Optional<Account> findByUsername(String username);
}
