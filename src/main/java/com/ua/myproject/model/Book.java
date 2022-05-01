package com.ua.myproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name", nullable = false)
    private String bookName;
    @Column(name = "Author", nullable = false)
    private String authorName;
    @Column(name = "Genre", nullable = false)
    private String bookGenre;
    @Column(name = "Year", nullable = false)
    private int publishingYear;
    @Column(name = "Price")
    private double bookPrice;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="year_id", referencedColumnName = "id")
    private Year year;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="price_id", referencedColumnName = "id")
    private Price price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="author_id", nullable = false)
    @JsonIgnore
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "bookGenres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Collection<Genre> genres;

    @JsonIgnore
    public Collection<Genre> getGenres(){
        return genres;
    }

}
