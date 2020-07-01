package com.lujieni.config;

import com.lujieni.bean.Person;
import com.lujieni.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther lujieni
 * @Date 2020/6/29
 *
 * 1)、@Autowired:自动注入
 *  1)、默认优先级按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class)
 *  2)、如果找到多个相同类型的组件,再将属性的名称作为组件的id去容器中查找
 *                          applicationContext.getBean("bookDao")
 *  3)、@Qualifier("bookDao"):使用@Qualifier指定需要装配的组件的id,而不是使用属性名
 *  4)、自动装配默认一定要将属性赋值好,没有就会报错;
 *      可以使用@Autowired(require=false);
 *  5)、@Primary:让Spring进行自动装配的时候,默认使用首选的bean;
 *         也可以继续使用@Qualifier指定需要装配的bean的名字
 *      BookService{
 *         @Autowired
 *         BookDao bookDao;
 *      }
 *
 *  2)、spring还支持使用@Resource(JSR250)和@Inject(JSR330)[Java规范的注解]
 *       @Resource:
 *          可以和@Autowired一样实现自动装配功能,默认是按照组件名称进行装配的
 *          没有能支持@Primary功能没有支持@Autowired(require=false);
 */
@ComponentScan({"com.lujieni.controller","com.lujieni.service","com.lujieni.dao"})
public class MainConfigOfAutowired {

    @Bean
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("bookDao2");
        return bookDao;
    }


}
