package com.example.jpademo.service;

import com.example.jpademo.JpademoApplication;
import com.example.jpademo.entity.BookEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpademoApplication.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private IBookService<BookEntity> iBookService;

    //运行时异常，回滚
    @Test
    public void testAddBook1() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("政治");
        BookEntity newBook = bookService.addBook1(bookEntity);
        Assert.assertEquals("政治", newBook.getName());
    }

    //编译时异常，不会回滚
    @Test
    public void testAddBook2() {
        BookEntity book1 = new BookEntity();
        book1.setName("政治");
        BookEntity newBook = bookService.addBook2(book1);
        Assert.assertEquals("政治", newBook.getName());
    }

    //运行时异常，事务注解在 default 方法上，不会回滚
    @Test
    public void testAddBook3() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("政治");
        BookEntity newBook = bookService.addBook3(bookEntity);
        Assert.assertEquals("政治", newBook.getName());
    }

    //运行时异常，在同一个类中无事务注解方法调用另一个有事务的方法，事务是不会起作用的。
    @Test
    public void testAddBook4() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("政治");
        BookEntity newBook = bookService.addBook4(bookEntity);
        Assert.assertEquals("政治", newBook.getName());
    }


    //@Transactional 注解在接口上，对于JDK 代理有效，Cglib代理无效
    //而，现在@Transactional 使用的是 Cglib 代理
    @Test
    public void testAddBook5() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("政治");
        BookEntity newBook = iBookService.addBook(bookEntity);
        Assert.assertEquals("政治", newBook.getName());
    }

}
