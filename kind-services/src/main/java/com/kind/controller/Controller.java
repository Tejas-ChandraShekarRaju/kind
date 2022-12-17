package com.kind.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private static final String template = "Hello, %s!";
	//private final AtomicLong counter = new AtomicLong();

	@CrossOrigin("*")
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return name;
	}
}
