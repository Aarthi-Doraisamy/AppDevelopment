package com.javatechie.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.repository.SignUpRepo;



@RestController
@CrossOrigin
@RequestMapping("/products")
public class Signup {
	@Autowired SignUpRepo repo;
	@PostMapping("/post")
	private Signup PostUser(@RequestBody Signup s){
		return repo.save(s);
	}
}
