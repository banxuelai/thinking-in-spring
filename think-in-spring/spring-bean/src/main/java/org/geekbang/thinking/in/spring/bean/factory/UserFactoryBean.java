package org.geekbang.thinking.in.spring.bean.factory;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link org.geekbang.thinking.in.springioc.overview.domain.User} Bean的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * @author bxl
 * @date 2022/2/22
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
