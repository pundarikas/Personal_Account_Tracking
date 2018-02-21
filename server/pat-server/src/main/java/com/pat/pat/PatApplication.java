package com.pat.pat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pat.pat.*")
public class PatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatApplication.class, args);
	}
}
