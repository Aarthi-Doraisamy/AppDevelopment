package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Book;
import com.service.BookService;

@RestController
@RequestMapping("/api/v1/plants")
@CrossOrigin("*")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/getall")  
	public Optional<List<Book>> GetAllBooks()   
	{  
		return bookService.getAllBook();  
	}  

	@GetMapping("/getid/{id}") 
	public ResponseEntity<Optional<Book>> GetPlant(@PathVariable long id)
	{  
		Optional<Book> pl = bookService.getBook(id); 
		return ResponseEntity.ok(pl);
	}  

	@DeleteMapping("/delete/{id}")  
	public ResponseEntity<Map<String, Boolean>> DeletePlant(@PathVariable long id)   
	{  
		bookService.deleteBook(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}  

	@PostMapping("/post")  
	public Book SavePlant(@RequestBody Book p)   
	{  
		return bookService.saveBook(p);  
	}  
	
	@PutMapping("/update")  
	public ResponseEntity<Book> UpdatePlant(@PathVariable long id,@RequestBody Book p)   
	{  
		Book pl = bookService.updateBook(p);  
		return ResponseEntity.ok(pl); 
	} 

}
