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
@WebMvcTest(SampleController.class)
public class SampleControllerTest5 {

	//log를 비롯하여 콘솔의 로그를 캡쳐한다.
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	// 실제 서버는 띄우지만 mock 데이터를 넣고 싶을때..
	// 실제 Controller 에서 사용하고있는 SampleService 를 @MockBean 을 사용하여 아래의
	// 즉, ApplicationContext에 들어있는 빈을 Mock으로 만든 객체로 교체를 하였다.
	@MockBean
	SampleService mockSampleService;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void hello() throws Exception {
		when(mockSampleService.getName()).thenReturn("changbonglee");
		mockMvc.perform(get("/hello")).andExpect(content().string("hello changbonglee"));
		
		//logger를 통한 log나 System.out.println 을 통한 log를 아래 명령어로 확인한다.
		assertThat(outputCapture.toString()).contains("changju hello").contains("skip");

	}
}
