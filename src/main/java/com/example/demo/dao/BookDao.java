package com.example.demo.dao;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dangdang on 2017/12/22.
 */
public interface BookDao extends JpaRepository<BookEntity, Long> {
}
