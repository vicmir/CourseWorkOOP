package com.ua.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })

public class MyprojectApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyprojectApplication.class, args);
	}

}
