package com.study.springboot.service;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class SampleService {

	public SampleService() {
		this.name = "changjulee";
	}

	private String name;

}
