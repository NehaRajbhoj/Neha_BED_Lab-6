package com.greatlearning.StudentAuthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("in.topthree.util")
public class StudentAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAuthorizationApplication.class, args);
	}

}
