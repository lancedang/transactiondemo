package com.example.jpademo.service;

public interface IBookService<T> {
    //@Transactional
    T addBook(T t);
}
