package com.study.springboot;

import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class SampleController {
	
	@GetMapping("/hello")
	public Resource<Hello> hello() {
		Hello hello = new Hello();
		hello.setPrefix("hey,");
		hello.setName("changju");
		
		Resource<Hello> helloResource = new Resource<>(hello);
		helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());
		
		return helloResource;
	}
}
