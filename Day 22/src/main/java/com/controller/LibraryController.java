package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Library;
import com.service.LibraryService;

@RequestMapping("/library")
public class LibraryController {
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/getall")  
	public Optional<List<Library>> GetAllLibrary()   
	{  
		return libraryService.getAllLibrary();  
	}  

	@GetMapping("/getid/{id}") 
	public ResponseEntity<Optional<Library>> GetUser(@PathVariable int id)
	{  
		Optional<Library> ga = libraryService.getGarden(id); 
		return ResponseEntity.ok(ga);
	}  

	@DeleteMapping("/delete/{id}")  
	public ResponseEntity<Map<String, Boolean>> DeleteGarden(@PathVariable int id)   
	{  
		libraryService.deleteGarden(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}  

	@PostMapping("/post")  
	public Library SaveGarden(@RequestBody Library g)   
	{  
		return libraryService.saveGarden(g);  
	}  
	
	@PutMapping("/update")  
	public ResponseEntity<Library> UpdateGarden(@PathVariable int id,@RequestBody Library g)   
	{  
		Library ga = libraryService.updateGarden(g);  
		return ResponseEntity.ok(ga); 
	} 
}
