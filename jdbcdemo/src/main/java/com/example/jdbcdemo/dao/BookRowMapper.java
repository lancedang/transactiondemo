package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.entity.BookEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BookEntity> {

    @Override
    public BookEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(rs.getInt("id"));
        bookEntity.setName(rs.getString("name"));
        return bookEntity;
    }
}

