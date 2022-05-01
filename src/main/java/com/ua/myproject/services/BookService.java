package com.ua.myproject.services;

import com.ua.myproject.model.Book;
import com.ua.myproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookService repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = (BookService) repository;
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }


    public void addBook (Book book){
        return repository.saveAndFlush();
    }

}
