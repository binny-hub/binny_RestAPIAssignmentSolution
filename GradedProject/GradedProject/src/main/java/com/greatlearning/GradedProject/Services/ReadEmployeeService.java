package com.greatlearning.GradedProject.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.greatlearning.GradedProject.Entity.Employee;
import com.greatlearning.GradedProject.Repository.EmployeeRepository;

@Service
public class ReadEmployeeService {
	
	@Autowired
	EmployeeRepository readRepository;
	public List<Employee> getEmployee(){
		
		return readRepository.findAll();	}
	
	public Page<Employee> getEmployeePaged() {
		
		PageRequest pageable = PageRequest.of(0, 3);
		return readRepository.findAll(pageable);
		
	}
	
	

}
