package org.geekbang.thinking.in.springioc.overview.domain;

import org.geekbang.thinking.in.springioc.overview.enums.City;

import javax.annotation.Resource;

/**
 * @author banxuelai001
 * @date 2020/8/21
 */
public class User {

    private Long id;
    private String name;
    private City city;

    private Resource configFileLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User createUser() {
        return new User();
    }
}
