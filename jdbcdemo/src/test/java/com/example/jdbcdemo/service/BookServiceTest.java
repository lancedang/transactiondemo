package com.example.jdbcdemo.service;

import com.example.jdbcdemo.JdbcdemoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = JdbcdemoApplication.class)
@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAdd() {
        bookService.addBook("german");
        Assert.assertEquals(bookService.getTheLastBook().getName(), "german");
    }

}
