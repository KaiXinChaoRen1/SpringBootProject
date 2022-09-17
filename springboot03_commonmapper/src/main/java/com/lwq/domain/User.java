package com.lwq.domain;


import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "user")
public class User {

    @Id
    private Integer id;
    private String username;
    private String password;
    private String build;
    private String util;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getUtil() {
        return util;
    }

    public void setUtil(String util) {
        this.util = util;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", build='" + build + '\'' +
                ", util='" + util + '\'' +
                '}';
    }

    public User(Integer id, String username, String password, String build, String util) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.build = build;
        this.util = util;
    }
}
