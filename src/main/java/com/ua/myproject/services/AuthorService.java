package com.ua.myproject.services;

import com.ua.myproject.model.Author;
import com.ua.myproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    public AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }


    public Optional <Author> getAuthorById(int id){
        return repository.findById(id);
    }

}
