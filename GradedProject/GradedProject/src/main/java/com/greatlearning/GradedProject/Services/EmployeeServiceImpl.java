package com.greatlearning.GradedProject.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.GradedProject.Entity.Employee;
import com.greatlearning.GradedProject.Entity.Role;
import com.greatlearning.GradedProject.Entity.User;
import com.greatlearning.GradedProject.Repository.EmployeeRepository;
import com.greatlearning.GradedProject.Repository.RoleRepository;
import com.greatlearning.GradedProject.Repository.UserRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
@Autowired
	
	EmployeeRepository employeeRepository;
@Autowired
RoleRepository roleRepository;
@Autowired
UserRepository userRepository;
@Autowired
BCryptPasswordEncoder bcryptEncoder;

	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> employee= employeeRepository.findAll();
		return employee;
	}

	
		
	@Override
	@Transactional
	public Employee findById(Long id) {
        Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return theEmployee;
	}

	public void addEmployee(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		employeeRepository.flush();
	}
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
		employeeRepository.flush();
	    return;	
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		List <Employee> employee= employeeRepository.findByfirstName(firstName);
		return employee;
	}



	@Override
	public List<Employee> sortByFirstName(String order) {
		if(order.equals("desc"))
			return employeeRepository.findAllByOrderByFirstNameDesc();
		else
			return employeeRepository.findAllByOrderByFirstNameAsc();
		}



	@Override
	public User saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);

	}



	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);

		
	}
	
	


}
