package com.study.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class PropertiesRef1 {
	@Value("${cjlee.name}")
	private String name;
}
