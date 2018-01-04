package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BookEntity findTheLastBook() {
        return jdbcTemplate.query("SELECT * FROM book ORDER BY id DESC ", new BookRowMapper()).get(0);
    }

    public List<BookEntity> findAllBooks() {
        return jdbcTemplate.query("select * from book", new BookRowMapper());
    }

    public void addBook(String bookName) {
        jdbcTemplate.update("insert into book VALUES (NULL, ?)", bookName);
    }

}

