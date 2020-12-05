package com.study.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
/*
 * @SpringBootTest
 * - @RunWith(SpringRunner.class) 와 같이 써야 함.
 * - webEnvironment
 *   - MOCK: mock servlet environment 내장 컨테이너(예: 톰켓) 구동 안함
 *   - RANDOM_PORT, DEFINED_PORT: 내장 컨테이너(예: 톰켓) 사용 함
 *   - NONE: 서블릿 환경 제공 안 함.
 * */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest1 {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void hello() throws Exception{
		mockMvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("hello changjulee"))
		.andDo(print());
		
	}
}
