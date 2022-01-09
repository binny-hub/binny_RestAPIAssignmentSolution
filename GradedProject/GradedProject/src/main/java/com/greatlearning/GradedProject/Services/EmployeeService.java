package com.greatlearning.GradedProject.Services;

import java.util.List;

import com.greatlearning.GradedProject.Entity.Employee;
import com.greatlearning.GradedProject.Entity.Role;
import com.greatlearning.GradedProject.Entity.User;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(Long id);

	public void save(Employee theEmployee);

	public void deleteById(Long theId);

	public List<Employee> searchByFirstName(String firstName);

	public List<Employee> sortByFirstName(String order);

	public User saveUser(User user);

	public Role saveRole(Role role);

}
