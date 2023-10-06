package com.javatechie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.controller.Signup;
import com.javatechie.repository.SignUpRepo;

@Service
public class SignupService {
	@Autowired 
	SignUpRepo repo;
//	public Iterable<SignUp> GetUserPassService(String username){
//		return repo.findAllUsernamePassword(username);
//	}
	public Iterable<Signup> GetAll(){
		return repo.findAll();
	}
	
}
