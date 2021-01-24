package com.study.springboot;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties("cjlee") // spring-boot-configuration-processor 에서 meta정보를 만들어 맵핑 후 바인딩을 받을 수 있게 한다.
@Validated
public class PropertiesRef2 {
	
	// @Validated에서 정의된 NotEmpty 를 사용 할 수 있다.
	// JSR-303 (@NotNull, ...), properties 에 빈 값이 들어가면 에러가 발생한다.
	@NotEmpty 
	String name;
	
	int age;
	
	// application.properties 에 sessionTimeout가 30으로 정의가 되어있는데 30은 해당 값으로 프로퍼티의 컨버전이 발생한다.
	// spring type conversion 에 의해서 Type이 변경이 되어 들어간다.
	@DurationUnit(ChronoUnit.SECONDS)
	private Duration sessionTimeout = Duration.ofSeconds(30);

}