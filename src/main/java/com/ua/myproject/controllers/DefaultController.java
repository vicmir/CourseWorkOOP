package com.ua.myproject.controllers;

import com.ua.myproject.model.Author;
import com.ua.myproject.model.Book;
import com.ua.myproject.model.Genre;
import com.ua.myproject.services.AuthorService;
import com.ua.myproject.services.BookService;
import com.ua.myproject.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DefaultController {

    private BookService service;
    private AuthorService authorService;
    private GenreService genreService;


    @Autowired
    public DefaultController(BookService service,AuthorService authorService,GenreService genreService) {
        this.service = service;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @PostMapping("/book")
    public void addBook(@RequestBody Book book) {
        service.addBook(book);
    }

    @GetMapping("/author")
    public ResponseEntity<Author> getAuthorById(@RequestParam(value="id")int id){

        Optional<Author> author = authorService.getAuthorById(id);

        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }

    @GetMapping("/genre")
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }
}



