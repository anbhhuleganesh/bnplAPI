package com.bnpl.fantasy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class predictionController {
	
	@GetMapping("{name}")
	public String hello(@PathVariable String name) {
		return String.format("Hello %s", name);
	}

}
