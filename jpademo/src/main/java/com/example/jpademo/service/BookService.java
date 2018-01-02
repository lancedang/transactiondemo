package com.example.jpademo.service;

import com.example.jpademo.dao.BookDao;
import com.example.jpademo.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dangdang on 2017/12/21.
 */
@Service
@Slf4j
public class BookService {

    @Autowired
    private BookDao bookDao;

    //创造运行时异常
    @Transactional
    public BookEntity addBook1(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        String makeTrouble = null;
        if (makeTrouble.equals("test"))
            System.out.println("RuntimeException 事务回滚");
        return bookEntity;
    }

    //编译时异常
    @Transactional
    public BookEntity addBook2(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        try {
            Class.forName("asdfas");
        } catch (ClassNotFoundException e) {
            log.info("CheckedException 事务不会回滚");
        }
        return bookEntity;
    }

    //创造运行时异常，但注解在 default
    @Transactional
    BookEntity addBook3(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        String makeTrouble = null;
        if (makeTrouble.equals("test"))
            System.out.println("RuntimeException 事务回滚");
        return bookEntity;
    }

    //运行时异常，在同一个类中无事务注解方法调用另一个有事务的方法，事务是不会起作用的。
    //@Transactional
    public BookEntity addBook4(BookEntity bookEntity) {
        //调用 事务方法
        bookEntity = innerTransactionMethod(bookEntity);
        return bookEntity;
    }


    @Transactional
    public BookEntity innerTransactionMethod(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        String makeTrouble = null;
        if (makeTrouble.equals("test"))
            System.out.println("RuntimeException 事务回滚");
        return bookEntity;
    }

}
