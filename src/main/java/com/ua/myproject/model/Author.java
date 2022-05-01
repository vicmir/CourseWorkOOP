package com.ua.myproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name", nullable = false)
    private String Name;
    @Column(name = "BirthYear", nullable = false)
    private String birthYear;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Collection<Book> books;

    }


