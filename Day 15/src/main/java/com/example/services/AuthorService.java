package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Author;
import com.example.repositories.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;


    public void createAuthor(Author author){
        authorRepository.save(author);

    }
    public void updateAuthor(Author author){
        authorRepository.updateAuthorDetails(author);
    }
    public void deleteAuthor(int id ){
        authorRepository.deleteCustom(id);
    }
}
