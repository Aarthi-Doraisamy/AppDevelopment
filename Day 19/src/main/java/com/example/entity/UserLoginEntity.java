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
@Table(name="UserLogin")
public class UserLoginEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userLoginId;
	private String Username;
	private String Password;


}
