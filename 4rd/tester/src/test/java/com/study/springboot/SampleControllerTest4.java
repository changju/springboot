package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import com.study.springboot.controller.SampleController;
import com.study.springboot.service.SampleService;
import static org.mockito.Mockito.when;

/*
 * 슬라이스 테스트
 * - 레이어 별로 잘라서 테스트하고 싶을때
 *  @JsonTest : ...
 *  @WebMvcTest : @Service, @Repository는 등록이 안됨.
 *  @WebFluxTest : ...
 *  @DataJpaTest : @Repository 만 등록 됨.
 * */
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class) // 컨트롤러 하나만 테스트하는 것
public class SampleControllerTest4 {


	// slice test를 하기 때문에 controller 를 제외한 나머지는 bean으로 등록이 안되기에
	// SampleService 같이 사용을 해야 하는것이 있다면, MockBean으로 등록 후 값을 채워 넣어야한다.
	@MockBean
	SampleService mockSampleService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("changbonglee");
		mockMvc.perform(get("/hello")).andExpect(content().string("hello changbonglee"));

	}
}
