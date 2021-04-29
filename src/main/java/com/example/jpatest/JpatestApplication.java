package com.example.jpatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpatestApplication.class, args);
	}

}
