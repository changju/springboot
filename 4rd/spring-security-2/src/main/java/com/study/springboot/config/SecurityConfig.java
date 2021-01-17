package com.study.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// WebSecurityConfigurerAdapter 에 정의되어 있던 것을 재정의 한다. 
	/* 기본의 형태는 다음과 같다.
	 * 	http
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin().and()
		.httpBasic();
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/hello").permitAll()
		.anyRequest().authenticated()
		.and()
	.formLogin()
		.and()
	.httpBasic();

	}
	
	/*
	 * "noop", "pbkdf2", "scrypt", "sha256" 과 같은 prefix 를 보며 encode를 하는 smart한 encoder가 아니라
	 * 그 smart한 bean 을 아무 것도 하지 않는 password encoder 로 변경을 한것이다.
	 * 되도록이면 아래 옵션을 절대 사용하지 않도록한다.
	 * */
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
		
		
	}
}
