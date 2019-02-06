package com.blood.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Staff {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
