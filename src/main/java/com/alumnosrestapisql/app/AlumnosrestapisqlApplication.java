package com.alumnosrestapisql.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class AlumnosrestapisqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumnosrestapisqlApplication.class, args);
	}

}
