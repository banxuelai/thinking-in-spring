package org.geekbang.thinking.in.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * byName 依赖 setter方法注入
 * @author bxl
 * @date 2022/3/23
 */
public class AutoWiringByNameDependencyInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";

        // 加载XML资源 解析并且创建BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 依赖查找并创建Bean
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.print(userHolder);
    }
}
