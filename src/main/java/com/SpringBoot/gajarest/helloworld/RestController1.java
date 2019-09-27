package com.SpringBoot.gajarest.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class RestController1 {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "Hi Kajanan";
	}

	@RequestMapping("/hello")
	public HelloBean beans() {
		return new HelloBean("Hi Kajanan");
	}

	@GetMapping(path = "hello/path-variable/{name}")
	public HelloBean helloPathvariable(@PathVariable String name) {
		// throw new RuntimeException("Something went wrong");
		return new HelloBean(String.format("Hi Buddy ,%S", name));

	}
}
