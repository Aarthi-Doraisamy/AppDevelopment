package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="UserRegister")
public class UserRegisterEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int UserRegisterId;
	private String Fullname;
	private Long Mobile;
	private String Email;
	private String Password;


}