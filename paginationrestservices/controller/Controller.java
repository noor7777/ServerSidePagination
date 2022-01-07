package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Emp;
import com.example.demo.services.EmpService;


@RestController
public class Controller {
    
	
	 @Autowired
	 private EmpService empService;

	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employee/{page}/{size}")
	public List<Emp> getEmp(@PathVariable int page,@PathVariable int size ){
		return  empService.getAllEmp();
	   		
		
	}
	
}

