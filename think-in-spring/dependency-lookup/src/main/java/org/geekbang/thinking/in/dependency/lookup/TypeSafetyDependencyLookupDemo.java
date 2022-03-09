package org.geekbang.thinking.in.dependency.lookup;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全 依赖查找示例
 * @author bxl
 * @date 2022/3/9
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
        // 注册bean
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 演示 BeanFactory#getBean 方法的安全性
        displayBeanFactoryGetBean(applicationContext);

        // 演示ObjectFactory#getObject 方法的安全性
        displayObjectFactoryGetObject(applicationContext);

        // 演示ObjectProvider#getIfAvailable 方法的安全性
        displayObjectProviderIfAvailable(applicationContext);

        // 演示 ListableBeanFactory#getBeansOfType 方法的安全性
        displayListableBeanFactory(applicationContext);

        // 演示ObjectProvider#stream 方法的安全性
        displayObjectProviderStream(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void displayObjectProviderStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);

        printBeanExceptionMessage("displayObjectProviderStream", () -> { objectProvider.forEach(System.out::println);});
    }

    private static void displayListableBeanFactory(ListableBeanFactory listableBeanFactory) {
        printBeanExceptionMessage("displayListableBeanFactory", () -> listableBeanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);

        printBeanExceptionMessage("displayObjectProviderIfAvailable ", objectProvider::getIfAvailable);
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {

        ObjectFactory<User> objectFactory = applicationContext.getBeanProvider(User.class);

        printBeanExceptionMessage("displayObjectFactoryGetObject ", objectFactory::getObject);
    }

    private static void displayBeanFactoryGetBean(BeanFactory beanFactory) {

        printBeanExceptionMessage("displayBeanFactoryGetBean ", () -> {
            beanFactory.getBean(User.class);
        });
    }

    private static void printBeanExceptionMessage(String source, Runnable runnable) {
        System.out.println("=================================");
        System.out.println("source from :" + source);

        try {
            runnable.run();
        } catch (BeansException exception) {
            exception.printStackTrace();
        }
    }
}
