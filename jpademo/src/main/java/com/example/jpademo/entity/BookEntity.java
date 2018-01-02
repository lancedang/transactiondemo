package com.example.jpademo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Dangdang on 2017/12/21.
 */
@Entity
@Data
@Table(name = "book", schema = "transactiondemo")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

}
