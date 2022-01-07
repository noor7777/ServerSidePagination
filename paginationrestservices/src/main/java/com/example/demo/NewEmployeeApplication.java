package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.example.demo.dao.EmployeeRepo", "com.example.demo.services","com.example.demo.controller"})
public class NewEmployeeApplication {
    
	
	public static void main(String[] args) {
		SpringApplication.run(NewEmployeeApplication.class, args);
	}

}
