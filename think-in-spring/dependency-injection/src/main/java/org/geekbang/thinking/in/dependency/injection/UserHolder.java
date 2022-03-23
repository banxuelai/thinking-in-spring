package org.geekbang.thinking.in.dependency.injection;

import org.geekbang.thinking.in.springioc.overview.domain.User;

/**
 * {@link User} Holder类
 * @author bxl
 * @date 2022/3/23
 */
public class UserHolder {

    private User user;

    public UserHolder () {

    }

    public UserHolder (User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
