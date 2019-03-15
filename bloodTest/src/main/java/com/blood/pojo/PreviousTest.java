/**
 * A Class representing the previous of blood tests for patients
 * 
 * @author Yeshvanth Prabakar, Patryck Whyte, Swapnil Paul, Zhenjie Jiang, Yilei
 *         Liang and Tao Lin
 * @version 2019.02.21
 * 
 */

package com.blood.pojo;

import org.springframework.context.annotation.Role;

import java.util.Set;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "previous_test")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class PreviousTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprevioustest")
    private int id;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private Date date;
    @Column(name = "commet")
    private String commet;
    @ManyToOne
    @JoinColumn(name = "idpatient")
    private Patient patient;

    public PreviousTest() {

    }

    public PreviousTest(String location, Date date, String comment) {
        this.location = location;
        this.date = date;
        this.commet = comment;
    }

    /**
     * getters to retrieve scheduling information for patients
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String comment) {
        this.commet = comment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}