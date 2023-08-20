package com.productmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JpaConfiguration.class)
public class ProductMapperApplication {

	/* TODO
	 * events
	 * listeners
	 * bean handeling
	 * aliases
	 * beans & parent & property
	 *
	 */

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProductMapperApplication.class);
		app.run(args);
	}


}
