package com.bnpl.fantasy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceSchemaCreatedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpl.fantasy.model.User;
import com.bnpl.fantasy.service.UserService;

@RestController
@RequestMapping("/bnpl/prediction")
public class PredictionController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("{name}")
	public String hello(@PathVariable("name") String name) {
		return String.format("Hello %s", name);
	}
	
	@GetMapping("/test")
	public void myTest() {
		List<String> myList = Arrays.asList("Ganesh","Meera","Reshma")
				.stream().filter(name -> name.startsWith("G")).collect(Collectors.toList());
		//myList.stream().map(name -> name.toLowerCase()).forEach(name -> System.out.println(name));
		//Stream<String> filteredList = myList.stream().filter(name -> name.startsWith("G"));
		System.out.println(myList);
		//System.out.println(filteredList.toString());
	}
	
	

}
