package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dangdang on 2017/12/21.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    public BookEntity addBook(@RequestBody BookEntity bookEntity) {
        BookEntity newBook = bookService.addBook(bookEntity);
        return newBook;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BookEntity updateBook(@RequestBody BookEntity bookEntity) {
        BookEntity updatedBook = bookService.addBook(bookEntity);
        return updatedBook;
    }

}