package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserRegisterEntity;

public interface UserRegisterRepository extends JpaRepository<UserRegisterEntity, Integer>{

}