package com.ua.myproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "price")
@Data
public class Price {
    @Id
    @Column(name = "price_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Price", nullable = false)
    private String price;
    @OneToOne(mappedBy = "price")
    @JsonIgnore
    private Book book;

}
