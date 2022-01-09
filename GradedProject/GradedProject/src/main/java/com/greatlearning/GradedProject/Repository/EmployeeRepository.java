package com.greatlearning.GradedProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.GradedProject.Entity.Employee;


public interface EmployeeRepository extends JpaRepository <Employee, Long> {
	List <Employee> findByfirstName(String firstName);
	
    List<Employee> findAllByOrderByFirstNameAsc();
	
	List<Employee> findAllByOrderByFirstNameDesc();
}
