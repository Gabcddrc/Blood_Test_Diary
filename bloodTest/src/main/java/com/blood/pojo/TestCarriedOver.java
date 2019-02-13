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
@Table(name = "test_carried_over")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class TestCarriedOver {

    @Id
    @Column(name = "idtest_carried_over")
    @GeneratedValue
    private int idtest_carried_over;
    @Column(name = "OPA")
    private String OPA;
    @Column(name = "date")
    private String date;
    @Column(name = "completed")
    private boolean completed;
    @Column(name = "commet")
    private String commet;
    @Column(name = "notified")
    private boolean notified;
    @Column(name = "idpatient")
    private int idpatient;
    @Column(name = "idlabel")
    private int idlabel;

    public int getIdtest_carried_over() {
        return idtest_carried_over;
    }

    public void setIdtest_carried_over(int idtest_carried_over) {
        this.idtest_carried_over = idtest_carried_over;
    }

    public String getOPA() {
        return OPA;
    }

    public void setOPA(String OPA) {
        this.OPA = OPA;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIdlabel() {
        return idlabel;
    }

    public void setIdlabel(int idlabel) {
        this.idlabel = idlabel;
    }
}