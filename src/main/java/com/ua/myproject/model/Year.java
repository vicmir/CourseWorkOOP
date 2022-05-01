package com.ua.myproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Data
public class Year {
    @Id
    @Column(name = "year_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Year", nullable = false)
    private String year;
    @OneToOne(mappedBy = "year")
    @JsonIgnore
    private Book book;
}
