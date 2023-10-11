package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AdminLoginEntity;
import com.example.repositories.AdminLoginRepository;

@Service
public class AdminLoginService {
	@Autowired
	private AdminLoginRepository adminLoginRepository;
	public List<AdminLoginEntity> getAdminLogin(){
		return adminLoginRepository.findAll();
	}
	public Optional<AdminLoginEntity> getAdminLoginbyId(int id){
		return adminLoginRepository.findById(id);
	}
	public void postAdminLogin(AdminLoginEntity ale) {
		adminLoginRepository.save(ale);
	}

}