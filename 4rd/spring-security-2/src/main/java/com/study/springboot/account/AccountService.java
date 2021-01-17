package com.study.springboot.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/*
 * spring security 를 추가하면 기본으로 등록되는 사용자가 있는데 아래 UserDetailsService 로 하여 bean 이 등록이 되어 있어야
 * 더 이상 기본 사용자가 추가되지 않는다. 
 */
@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		//account.setPassword(password); spring security 에서는 그냥 password를 db에 넣으면 절대 안된다.
		//이와같이 넣고 login 시도를 하면 에러처리 난다.
		account.setPassword(passwordEncoder.encode(password));
		return accountRepository.save(account);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> byUsername = accountRepository.findByUsername(username);
		Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));

		return new User(account.getUsername(), account.getPassword(), authorities());
	}

	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
