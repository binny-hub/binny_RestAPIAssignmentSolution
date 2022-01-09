package com.greatlearning.GradedProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.GradedProject.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.username= ?1")
	 public User getUserByUsername(String username); //class variable

}
