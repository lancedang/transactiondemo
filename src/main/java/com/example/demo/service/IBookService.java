package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;

public interface IBookService<T> {
    //@Transactional
    T addBook(T t);
}
