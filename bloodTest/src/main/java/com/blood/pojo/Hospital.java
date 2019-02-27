/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blood.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.context.annotation.Role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Swapnil Paul
 */
@Entity
@Table(name = "hospitals")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhospital")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    public Hospital(){
        super();
    }

    public Hospital(String name,String address,String email,String phone){
        super();
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getIdhospital() {
        return id;
    }

    public void setId(int idhospital) {
        this.id = idhospital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
