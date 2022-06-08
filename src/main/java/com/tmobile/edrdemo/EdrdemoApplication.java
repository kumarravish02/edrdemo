package com.tmobile.edrdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EdrdemoApplication /* extends SpringBootServletInitializer */ {

	@GetMapping("/message")
	public String message()	{
		return "Hello World";
	}
	public static void main(String[] args) {
		SpringApplication.run(EdrdemoApplication.class, args);
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(EdrdemoApplication.class); }
	 */
}
