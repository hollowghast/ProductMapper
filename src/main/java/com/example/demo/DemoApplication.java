package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	/** TODO
	 * events
	 * listeners
	 * bean handeling
	 * aliases
	 * beans & parent & property
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.run(args);
	}


}
