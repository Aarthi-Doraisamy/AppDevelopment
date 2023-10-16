package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{
	
}
