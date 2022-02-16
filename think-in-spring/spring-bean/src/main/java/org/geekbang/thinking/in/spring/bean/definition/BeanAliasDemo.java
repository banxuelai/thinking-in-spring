package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 别名示例
 * @author bxl
 * @date 2022/2/16
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        // 通过别名 获取 bean
        User bxlUser = beanFactory.getBean("bxl_user", User.class);

        User user = beanFactory.getBean("user", User.class);

        System.out.println("bxl_user 和 user bean 是否相同：" + (bxlUser == user));
    }
}
