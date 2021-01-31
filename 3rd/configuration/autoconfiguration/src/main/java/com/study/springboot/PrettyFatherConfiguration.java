package com.study.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableConfigurationProperties 가 있어야 bean으로 등록을 해주고 meta 정보에서 값 을 넣어준다.
//@EnableConfigurationProperties(PrettyFatherProperties.class)

@Configuration
@EnableConfigurationProperties(PrettyFatherProperties.class)
public class PrettyFatherConfiguration {

	@Bean
	@ConditionalOnMissingBean // 등록이 되어진 bean 이 없으면 등록 하여
	public PrettyFather prettyFather(PrettyFatherProperties properties) {
		PrettyFather pFather = new PrettyFather();
		pFather.setName(properties.getName());
		pFather.setOld(properties.getOld());
		return pFather;
	}
}
