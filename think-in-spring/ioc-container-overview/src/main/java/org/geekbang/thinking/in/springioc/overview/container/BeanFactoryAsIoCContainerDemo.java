package org.geekbang.thinking.in.springioc.overview.container;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/** IoC容器 示例
 * @author bxl
 * @date 2022/1/7
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // xml配置文件 classpath
        String location  = "classpath:/META-INF/dependency-lookup-context.xml";

        // 加载配置
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);

        System.out.println("Bean定义加载的数量：" + beanDefinitionsCount);

        // 依赖查找集合对象
        lookupCollectionsByType(beanFactory);
    }

    private static void lookupCollectionsByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User 集合对象：" + users);
        }
    }
}
