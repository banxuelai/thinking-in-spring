package org.geekbang.thinking.in.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link NoUniqueBeanDefinitionException}
 * @author bxl
 * @date 2022/3/15
 */
public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
        // 注册bean
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        try {
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.err.printf("Spring 应用上下文存在%s个，%s类型的bean，具体原因是%s%n", e.getNumberOfBeansFound(), String.class.getName(), e.getMessage());
        }

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String beanOne() {
        return "BeanOne";
    }

    @Bean
    public String beanTwo() {
        return "BeanTwo";
    }

    @Bean
    public String bean3() {
        return "Bean3";
    }
}
