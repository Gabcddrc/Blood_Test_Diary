/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blood.pojo;

import org.springframework.context.annotation.Role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Swapnil
 */
@Entity
@Table(name = "patients")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Patient {

    @Id
    @Column(name = "idpatient")
    @GeneratedValue
    private int id;
    @Column(name = "forename")
    private String forename;
    @Column(name = "surname")
    private String surname;
    @Column(name = "DOB")
    private String DOB;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private char sex;
    @Column(name = "address")
    private String address;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "trasplant")
    private String trasplant;
    @Column(name = "local_hospital")
    private String local_hospital;
    @Column(name = "surgery")
    private String surgery;
    @Column(name = "commets")
    private String commets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTrasplant() {
        return trasplant;
    }

    public void setTrasplant(String trasplant) {
        this.trasplant = trasplant;
    }

    public String getLocal_hospital() {
        return local_hospital;
    }

    public void setLocal_hospital(String local_hospital) {
        this.local_hospital = local_hospital;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public String getCommets() {
        return commets;
    }

    public void setCommets(String commets) {
        this.commets = commets;
    }

    public Boolean getOverTime() {
        return overTime;
    }

    public void setOverTime(Boolean overTime) {
        this.overTime = overTime;
    }

    private Boolean overTime;
}
