package com.study.springboot.user;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class) //slice test, web 계층만 테스트 한다.
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc; // @WebMvcTest 를 사용하면 빈을 사용 할 수 있다.

	@Test
	public void hello() throws Exception {
		mockMvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("hello"));
	}

	@Test
	public void createUser_JSON() throws Exception {
		String userJson = "{\"username\":\"changjulee\",\"password\":\"123\"}";
		mockMvc.perform(post("/users/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(userJson))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.username", is(equalTo("changjulee"))))
		.andExpect(jsonPath("$.password", is(equalTo("123"))))
		.andDo(print());

	}
	
	// 뷰 리졸비 설정 제공 : 아무것도 하지 않으면 기본으로 json 으로 제공을 한다.
	// ViewResolver 를 제공하는 클래스는 HttpMessageConvertersAutoConfiguration 에서 제공한다.
	// AcceptType 을 확인 후 그에 맞는 것을 제공하며, 제공을 하고자하는 컨버터 또한 필요로한다.
	// XML 메시지 컨버터 추가 : groupId: com.fasterxml.jackson.dataformat
	/* 다음의 의존성을 설치 해줘야 한다.
	 * 	<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
			<version>2.9.6</version>
		</dependency>
	 * */
	@Test
	public void createUser_XML() throws Exception {
		String userJson = "{\"username\":\"changjulee\",\"password\":\"123\"}";
		mockMvc.perform(post("/users/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_XML)
				.content(userJson))
				.andExpect(status().isOk())
		.andExpect(xpath("/User/username").string("changjulee"))
		.andExpect(xpath("/User/password").string("123"))
		.andDo(print());
	}
	
	

}
