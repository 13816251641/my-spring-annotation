package com.lujieni.dao;

import org.springframework.stereotype.Repository;

/**
 * @Auther lujieni
 * @Date 2020/5/29
 */
@Repository
public class BookDao {

    private String label="bookDao";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
