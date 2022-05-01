package com.ua.myproject.services;

import com.ua.myproject.model.Genre;
import com.ua.myproject.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository repository;

    @Autowired
    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    public List<Genre> getAllGenres(){
        return repository.findAll();
    }
}
