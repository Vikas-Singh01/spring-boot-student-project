package com.qsp.springbootcrudstudentproject.repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springbootcrudstudentproject.bean.User;

public interface UserRepositery extends JpaRepository<User, Integer>{
	  public Optional<User> findByEmail(String email);
}
