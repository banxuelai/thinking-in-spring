package org.geekbang.thinking.in.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  层次性依赖查找示例
 * @author bxl
 * @date 2022/3/3
 */
public class HierarchicalDependencyLookupDemo { // @Configuration 是非必须的注解

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
        // 注册bean
        applicationContext.register(HierarchicalDependencyLookupDemo.class);

        /**
         *  {@link org.springframework.beans.factory.config.ConfigurableListableBeanFactory}
         */
        // 1.获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前BeanFactory 的 Parent BeanFactory is:" + beanFactory.getParentBeanFactory());

        // 2. 设置ParentBeanFactory
        beanFactory.setParentBeanFactory(createParentBeanFactory());

        // 启动应用上下文
        applicationContext.refresh();


        // 关闭应用上下文
        applicationContext.close();
    }

    private static BeanFactory createParentBeanFactory() {

        // 创建beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // xml配置文件 classpath
        String location  = "classpath:/META-INF/dependency-lookup-context.xml";

        // 加载配置
        reader.loadBeanDefinitions(location);

       return  beanFactory;
    }
}
