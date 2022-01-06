package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Emp;

@Service
public interface EmpService {
 
	List<Emp> getAllEmp(int page , int size);

	long getCountOfEntities();
}
