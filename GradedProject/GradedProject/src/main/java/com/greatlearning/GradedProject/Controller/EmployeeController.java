package com.greatlearning.GradedProject.Controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.GradedProject.Entity.Employee;
import com.greatlearning.GradedProject.Entity.Role;
import com.greatlearning.GradedProject.Entity.User;
import com.greatlearning.GradedProject.Repository.EmployeeRepository;
import com.greatlearning.GradedProject.Services.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
		
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return employeeService.saveUser(user);
		
	}
	
	@PostMapping("/role")
	public Role SaveRole(@RequestBody Role role) {
		
		return employeeService.saveRole(role);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findAll();
		
	}
	
	//add mapping for GET /employees/{employeeId}
	@GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
		
		Employee theEmployee = employeeService.findById(id);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		return theEmployee;
	}
	
	
	// add mapping for POST  / employees - add a new employee
	
	@PostMapping("/employee")
public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theEmployee.setId((long)0);	
		//theEmployee.getId();
		//theEmployee.getEmailId();
		//theEmployee.getFirstName();
		//theEmployee.getLastName();
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for PUT /employees - update existing employee
	
		@PutMapping("/employee")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			
			employeeService.save(theEmployee);
			
			return theEmployee;
		}
	
		// add mapping for DELETE /employees/{employeeId} - delete employee
		
		@DeleteMapping("/employees/{Id}")

		public String deleteEmployee(@PathVariable Long id) {
			
			Employee tempEmployee = employeeService.findById(id);
			
			// throw exception if null
			
			if (tempEmployee == null) {
				throw new RuntimeException("Employee id not found - " + id);
			}
			
			employeeService.deleteById(id);
			
			return "Deleted employee id - " + id;
		}	
		
		@GetMapping("/employee/search/{firstName}")
		public List <Employee> searchByFirstName(@PathVariable String firstName){
			return employeeService.searchByFirstName(firstName);
		}
		
		@GetMapping("/employee/sort")
		public List<Employee> sortByFirstName(@RequestParam(name = "order")String order){
			
			return employeeService.sortByFirstName(order);
		}
	
}
