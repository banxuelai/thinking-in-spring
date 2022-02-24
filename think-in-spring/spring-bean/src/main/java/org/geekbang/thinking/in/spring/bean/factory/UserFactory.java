package org.geekbang.thinking.in.spring.bean.factory;

import org.geekbang.thinking.in.springioc.overview.domain.User;

/**
 * @author bxl
 * @date 2022/2/22
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

    void initUserFactory();
}
