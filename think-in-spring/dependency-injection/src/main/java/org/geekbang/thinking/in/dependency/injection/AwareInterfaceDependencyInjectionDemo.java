package org.geekbang.thinking.in.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于{@link Aware} 接口回调的依赖注入
 * @author bxl
 * @date 2022/3/23
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {

    private static BeanFactory beanFactory;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
    }

    @Override
    public  void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }

    public static void main(String[] args) {
        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 1. 通过@Bean 方式定义
        applicationContext.register(AwareInterfaceDependencyInjectionDemo.class);

        applicationContext.refresh();

        System.out.print(beanFactory == applicationContext.getBeanFactory());

        // 关闭应用上下文
        applicationContext.close();
    }
}
