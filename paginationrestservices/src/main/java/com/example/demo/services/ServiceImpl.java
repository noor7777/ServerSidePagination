package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.entity.Emp;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements EmpService{

	@Autowired
	private EmployeeRepo repo;
	
    @Override
	public List<Emp> getAllEmp(int page , int size) {
		 List<Emp> out = new ArrayList<Emp>();
		   Pageable firstwith100 = PageRequest.of(page, size);

	        repo.findAll(firstwith100).forEach(e -> out.add(e));
	        return out;
	        
	}
    public long getCountOfEntities() {
		long count = repo.count();
		return count;
	}
}
