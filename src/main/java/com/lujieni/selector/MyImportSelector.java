package com.lujieni.selector;

import com.lujieni.bean.Pink;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther lujieni
 * @Date 2020/6/10
 * 自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 需要导入到容器中的组件全类名
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
       /*
            扫描配置类所在的包下的Pink类并装配为bean
            String packageName = null;
            try {
                packageName = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String[] basePackages = new String[] {packageName};
            ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
            TypeFilter helloServiceFilter = new AssignableTypeFilter(Pink.class);
            scanner.addIncludeFilter(helloServiceFilter);
            Set<String> classes = new HashSet<>();
            for (String basePackage : basePackages) {
                scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> classes.add(beanDefinition.getBeanClassName()));
            }
            return classes.toArray(new String[classes.size()]);
       */


      /*
            扫描@ComponentScan指定的Package下的Pink类并装配为bean
            Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            String[] basePackages = (String[]) annotationAttributes.get("basePackages");
            ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
            TypeFilter helloServiceFilter = new AssignableTypeFilter(Pink.class);
            scanner.addIncludeFilter(helloServiceFilter);
            Set<String> classes = new HashSet<>();
            for (String basePackage : basePackages) {
                scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> classes.add(beanDefinition.getBeanClassName()));
            }
            return classes.toArray(new String[classes.size()]);
        */


        return new String[]{"com.lujieni.bean.Pink"};
    }
}
