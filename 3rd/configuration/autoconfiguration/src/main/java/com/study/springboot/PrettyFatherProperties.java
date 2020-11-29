package com.study.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ConfigurationProperties("prettyfather")
public class PrettyFatherProperties {
	String name;
	int old;

}
