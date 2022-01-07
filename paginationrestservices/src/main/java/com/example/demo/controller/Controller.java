package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Emp;
import com.example.demo.services.EmpService;


@RestController
public class Controller {
    
	
	 @Autowired
	 private EmpService empService;

	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employee/{page}/{size}")
	@ResponseBody
	public List<Emp> getEmp(@PathVariable int page,@PathVariable int size ){
		
		List<Emp> employeeList =new ArrayList<Emp>();
				employeeList =  empService.getAllEmp(page,size);
				System.out.println("This is Page" + page);
				System.out.println("This is Size" + size);
				employeeList.forEach(System.out::println);
		return employeeList ;
	   		
		
	}
    
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employee")
	@ResponseBody
	public long countEntities() {
		long count = empService.getCountOfEntities();
	
		return count;
	}
	
}

