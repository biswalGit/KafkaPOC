package com.pit.employeems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EmployeemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemsApplication.class, args);
	}

}
