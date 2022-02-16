package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * (@link BeanDefinition) 构建示例
 * @author bxl
 * @date 2022/2/15
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1. 通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 22).addPropertyValue("name", "bxl");

        // 获取BeaDefinition对象
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 此时 beanDefinition并不是最终状态，可以自定义修改

        /**
         * =================================================================================================
         */

        // 2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id", 23);
        mutablePropertyValues.addPropertyValue("name", "bxlxxx");

        // 通过set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }
}
