package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	@GetMapping("/hello")
	public String hello(Model model) {
		
		// model 이 전달받은 data를 어떻게 template 에 적용을 할 것인지. 
		model.addAttribute("name", "changjulee");
		
		// 아래 hello는 view의 이름이다.
		return "hello";
	}
}
