package org.geekbang.thinking.in.dependency.injection;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于API 实现依赖Setter方法注入示例
 * @author bxl
 * @date 2022/3/23
 */
public class ApiDependencyInjectionDemo {

    public static void main(String[] args) {

        // 创建beanFactory容器
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();

        // 生成UserHolder的BeanDefinition
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();

        // 注册userHolder的BeanDefinition
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.print(userHolder);

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * {@link UserHolder} 生成 {@link BeanDefinition}
     * @return
     */
    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addPropertyReference("user", "superUser");
        return builder.getBeanDefinition();
    }

//    @Bean
//    public  UserHolder userHolder(User user) {
//
//        return new UserHolder(user);
//    }
}
