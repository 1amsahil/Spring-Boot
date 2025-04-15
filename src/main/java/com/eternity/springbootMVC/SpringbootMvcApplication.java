package com.eternity.springbootMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootMvcApplication {

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(SpringbootMvcApplication.class, args);
	}

}
