package org.geekbang.thinking.in.springioc.overview.dependency.domain;

import org.geekbang.thinking.in.springioc.overview.dependency.annotation.Super;

/**
 * @author banxuelai001
 * @date 2020/8/24
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
