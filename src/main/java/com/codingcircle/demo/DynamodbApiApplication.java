package com.codingcircle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamodbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamodbApiApplication.class, args);
		System.out.println("Started at port 8080");
	}

}
