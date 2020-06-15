package com.lujieni.config;
import com.lujieni.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Auther ljn
 * @Date 2020/2/15
 * 基于配置类
 */
/*
        value一定要指定扫描的包的范围
        @ComponentScan(value = "com.lujieni")
 */


/*
        指定排除
        @ComponentScan(value = "com.lujieni",
               excludeFilters = {
                                    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
                                })
*/

/*
 *
 *      指定加入,useDefaultFilters=false代表不使用默认过滤条件,这里的结果是bookController,bookService被扫描进来
 *
        @ComponentScan(value = "com.lujieni",
               includeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
            },useDefaultFilters = false)
*/


/*
 * FilterType.CUSTOM会扫描com.lujieni包下的所有的类,但由于MainConfigWithComponetscan类已经被
 * new AnnotationConfigApplicationContext扫描到了所以MyTypeFilter无法扫描到MainConfigWithComponetscan类
 * 还有includeFilters取得是所有过滤条件的并集
 */
@ComponentScan(value = "com.lujieni",
               includeFilters = {
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
               },useDefaultFilters = false
)

public class MainConfigWithComponetscan {


}
