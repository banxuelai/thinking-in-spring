package org.geekbang.thinking.in.springioc.overview.repository;

import org.geekbang.thinking.in.springioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.applet.AppletContext;
import java.util.Collection;

/**
 * User数据仓储
 * @author bxl
 * @date 2022/1/5
 */
public class UserRepository {

    private Collection<User> users; // 自定义bean
    private BeanFactory beanFactory;    // 内建非Bean对象 （依赖）
    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }
}
