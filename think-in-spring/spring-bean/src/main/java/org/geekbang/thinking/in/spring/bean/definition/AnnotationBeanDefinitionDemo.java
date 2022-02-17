package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解 BeanDefinition定义
 * @author bxl
 * @date 2022/2/17
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 通过BeanDefinition 注册 API实现
        // 1. 命名 bean 的注册方式
        registryUserBeanDefinition(applicationContext, "bxl");
        // 2. 非命名 bean 的注册方式
        registryUserBeanDefinition(applicationContext);

        // 1. 通过@Bean 方式定义
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        applicationContext.refresh();

        System.out.println("Config 类型的所有Beans :" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有Beans :" + applicationContext.getBeansOfType(User.class));

        // 2. 通过@Component 方式定义

        // 3. 通过@Import 方式定义

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 命名 Bean的注册方式
     * @param beanDefinitionRegistry
     * @param beanName
     */
    public static void registryUserBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, String beanName) {

        BeanDefinitionBuilder builder = genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1).addPropertyValue("name", "bxl");

        if(StringUtils.hasText(beanName)) {
            beanDefinitionRegistry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), beanDefinitionRegistry);
        }
    }

    public static void registryUserBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry) {
        registryUserBeanDefinition(beanDefinitionRegistry, null);
    }

    @Component
    public static class Config {

        @Bean(name = {"user", "xiaomage-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小马哥");
            return user;
        }
    }

}
