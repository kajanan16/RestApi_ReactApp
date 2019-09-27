package com.SpringBoot.gajarest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class BasicAuthentication {

	@GetMapping(path = "/basicauth")
	public AuthBean helloPathvariable() {
		// throw new RuntimeException("Something went wrong");
		return new AuthBean("You are authenticated");

	}
}
