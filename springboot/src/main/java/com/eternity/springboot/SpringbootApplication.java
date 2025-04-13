package com.eternity.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

		Programmer obj = context.getBean(Programmer.class);
		obj.code();
	}

}
