package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Library;
import com.repository.LibraryRepository;


@Service

public class LibraryService {
	@Autowired
	LibraryRepository libraryRepository;
	
	public Optional<List<Library>> getAllLibrary()   
	{  
		return Optional.of(libraryRepository.findAll());
	}  
	
	public Optional<Library> getGarden(int id)   
	{  
		return libraryRepository.findById(id); 
	}
	
	public void deleteGarden(int id)   
	{  
		libraryRepository.deleteById(id);  
	}
	
	public Library saveGarden(Library g)   
	{  
		return libraryRepository.save(g);  
	}
	
	public Library updateGarden(Library g)   
	{  
		libraryRepository.save(g);  
		return g;  
	}

	}

