package com.example.jdbcdemo.service;

import com.example.jdbcdemo.dao.BookDao;
import com.example.jdbcdemo.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<BookEntity> getBooks() {
        return bookDao.findAllBooks();
    }

    public BookEntity getTheLastBook() {
        return bookDao.findTheLastBook();
    }

    @Transactional
    public void addBook(String bookName) {
        bookDao.addBook(bookName);
        String fuse = null;
        System.out.println(fuse.equals(""));
    }

}
