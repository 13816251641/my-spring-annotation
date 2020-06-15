package com.lujieni.bean;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther ljn
 * @Date 2020/2/15
 */
@Data
@Accessors(chain = true)
public class Person {
    private String name;
    private Integer age;

}
