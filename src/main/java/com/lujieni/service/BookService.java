package com.lujieni.service;

import com.lujieni.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther lujieni
 * @Date 2020/5/29
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao2;

    public void print(){
        System.out.println(bookDao2.getLabel());
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao2 +
                '}';
    }
}
