package com.sita.task1B.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sita.task1B.user" })
public class AddUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddUserApplication.class, args);
	}

}
