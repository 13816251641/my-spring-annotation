package com.lujieni.bean;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther ljn
 * @Date 2020/2/15
 */
@Data
@Accessors(chain = true)
public class Person {
    @Value("张三")
    private String name;
    @Value("${person.age}")
    private Integer age;

}
