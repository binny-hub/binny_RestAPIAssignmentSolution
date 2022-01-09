package com.greatlearning.GradedProject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import com.greatlearning.GradedProject.Entity.Employee;
import com.greatlearning.GradedProject.Services.EmployeeServiceImpl;
import com.greatlearning.GradedProject.Services.ReadEmployeeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class GradedProjectApplication {
    
	@Autowired
	ReadEmployeeService readEmployeeServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(GradedProjectApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		log.info("Fetch Employees-> {}", readEmployeeServiceImpl.getEmployee());
		
		Page<Employee> page = readEmployeeServiceImpl.getEmployeePaged();
		List<Employee> employee= page.get().collect(Collectors.toList());
		log.info("Fetch Employees in Page format -> {}", readEmployeeServiceImpl.getEmployeePaged());
	
	
	}
	

}
