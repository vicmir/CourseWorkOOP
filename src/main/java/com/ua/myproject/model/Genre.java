package com.ua.myproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genre")
@Data
public class Genre {
    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name", nullable = false)
    private String genreName;

    @ManyToMany (mappedBy = "genres")
    private Collection<Book> books;
}
