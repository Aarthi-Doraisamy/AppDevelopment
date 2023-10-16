package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Book;
import com.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public Optional<List<Book>> getAllBook()   
	{  
		return Optional.of(bookRepository.findAll());
	}  
	
	public Optional<Book> getBook(long id)   
	{  
		return bookRepository.findById(id); 
	}
	
	public void deleteBook(long id)   
	{  
		bookRepository.deleteById(id);  
	}
	
	public Book saveBook(Book p)   
	{  
		return bookRepository.save(p);  
	}
	
	public Book updateBook(Book p)   
	{  
		bookRepository.save(p);  
		return p;  
	}
}
