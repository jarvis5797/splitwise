package com.jarvis.splitWise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.splitWise.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}