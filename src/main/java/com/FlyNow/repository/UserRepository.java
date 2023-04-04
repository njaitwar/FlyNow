package com.FlyNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlyNow.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
