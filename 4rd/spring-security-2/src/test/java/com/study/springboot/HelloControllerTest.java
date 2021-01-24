package com.study.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	/*
	 * spring-boot-starter-security 를 추가 후 Unauthorized 401 이 발생을 한다.
	 * 모든 요청이 모두 인증을 필요로 하게 된다.
	 * spring-security-test 를 추가 후 @WithMockUser 를 추가해야 한다.
	 * */
	@Test
	@WithMockUser
	public void hello() throws Exception {
		mockMvc.perform(get("/hello")
		               .accept(MediaType.TEXT_HTML))
		       .andDo(print())
		       .andExpect(status().isOk())
		       .andExpect(view().name("hello"));
		
	}
	
	@Test
	public void hello_without_user() throws Exception {
		mockMvc.perform(get("/hello"))
		       .andDo(print())
		       .andExpect(status().isUnauthorized());
	}
	
	
	
	@Test
	@WithMockUser
	public void my() throws Exception {
		mockMvc.perform(get("/my"))
		       .andDo(print())
		       .andExpect(status().isOk())
		       .andExpect(view().name("my"));
		
	}
	
	
	
	
}
