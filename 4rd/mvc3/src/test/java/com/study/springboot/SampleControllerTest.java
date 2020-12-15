package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
	
	@Autowired
	MockMvc mockMvc; // 실제 서블릿이 아닌 가짜 서블릿이다.
	
	// WebClient 주입 받기 
	@Autowired
	WebClient webClient; // HtmlUnit 사용함, webClient 내에서도 결국 mockMvc 를 사용을 한
	
	@Test
	public void hello1() throws Exception {
		// 요청 "/hello"
		// 응답
		//   - 모델 name : changjulee
		//   - 뷰 이름 : hello
		
		mockMvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("name", is("changjulee")))
		//.andExpect(xpath("//h1").string("changjulee")) :xml 값 확인하기
		.andExpect(content().string(containsString("changjulee")))
		.andDo(print());
	}

	// HtmlUnit 사용해보기
	// html 에 특화된 test 작업을 할 수 있다.
	@Test
	public void hello2() throws Exception {
		HtmlPage page = webClient.getPage("/hello");
		HtmlHeading1 h1 = page.getFirstByXPath("//h1");
		assertThat(h1.getTextContent()).isEqualToIgnoringCase("changjulee");
		
	}
}
