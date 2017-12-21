package com.example.demo.service;


import com.example.demo.dao.BookDao;
import com.example.demo.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Dangdang on 2017/12/21.
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    public BookEntity addBook(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        return bookEntity;
    }

    @Transactional
    public BookEntity updateBook(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        return bookEntity;
    }
}
