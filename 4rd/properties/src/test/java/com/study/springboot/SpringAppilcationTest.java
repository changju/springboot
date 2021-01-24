package com.study.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * test아래 application.properties 가 src의 resources에 있는 이름과 중복이 된다면 
 * test에 있는 application.properties 의 우선순위가 높기 때문에 오버라이딩이 되어버려 src의 resource 의 값이 무의미해진다.
 * 이를 방지하기 위하여 properties 이름을 달리줘야 한다.
 * */
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:/application_test.properties")
@SpringBootTest
public class SpringAppilcationTest {

	@Autowired
	Environment environment;

	@Test
	public void contestLoads() {
		assertThat(environment.getProperty("cjlee.name")).isEqualTo("changju");
		assertThat(environment.getProperty("cjlee.fullName")).isEqualTo("changju lee");
		
		
	}
}