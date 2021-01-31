package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.study.springboot.service.SampleService;
import static org.mockito.Mockito.when;

/*
 * @SpringBootTest
 * - @RunWith(SpringRunner.class) 와 같이 써야 함.
 * - webEnvironment
 *   - MOCK: mock servlet environment 내장 톰캣 구동 안함
 *   - RANDOM_PORT, DEFINED_PORT: 내장 톰캣 사용 함
 *   - NONE: 서블릿 환경 제공 안 함.
 * @MockBean
 * - ApplicationContext 에 들어있는 빈을 Mock으로 만든 객체로 교체 함.
 * - 모든 @Test 마다 자동으로 리셋 함.
 * */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest2 {
	
	// 실제 서버가 띄워지고 실제 데이터를 확인해보고 싶을때.
	@Autowired
	TestRestTemplate testRestTemplate;
	
	// 실제 서버는 띄우지만 mock 데이터를 넣고 싶을때..
	// 실제 Controller 에서 사용하고있는 SampleService 를 @MockBean 을 사용하여 아래의
	// 즉, ApplicationContext에 들어있는 빈을 Mock으로 만든 객체로 교체를 하였다.
	@MockBean
	SampleService mockSampleService;
	
	@Test
	public void hello() throws Exception{
		
		// Service의 getName이 호출이되면 changbonelee 를 호출하라 라고 Mock을 설정한다.
		when(mockSampleService.getName()).thenReturn("changbonglee");
		
		String result = testRestTemplate.getForObject("/hello", String.class);
		assertThat(result).isEqualTo("hello changbonglee");
	}
}
