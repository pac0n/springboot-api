package com.pacon.apionce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacon.apionce.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByUserId(int id);
	
	User deleteById(int id);

}
