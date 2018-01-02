package com.example.jpademo.service;


import com.example.jpademo.dao.BookDao;
import com.example.jpademo.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BookServiceImpl implements IBookService<BookEntity> {

    @Autowired
    private BookDao bookDao;

    //@Transactional 注解在接口上，对于JDK 代理有效，Cglib代理无效
    @Transactional
    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        bookEntity = bookDao.save(bookEntity);
        String makeTrouble = null;
        if (makeTrouble.equals("test"))
            System.out.println("RuntimeException 事务回滚");
        return bookEntity;
    }
}
