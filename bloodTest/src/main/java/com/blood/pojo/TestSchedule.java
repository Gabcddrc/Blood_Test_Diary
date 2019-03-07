/**
 * A Class representing the scheduling of blood tests for patients
 * 
 * @author Yeshvanth Prabakar, Patryck Whyte, Swapnil Paul, Zhenjie Jiang, Yilei Liang and Tao Lin
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "test_schedule")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class TestSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtest_schedule")
    private int id;
    @Column(name = "OPA")
    private String OPA;
    @Column(name = "date")
    private Date date;
    @Column(name = "completed")
    private boolean completed;
    @Column(name = "commet")
    private String commet;
    @Column(name = "notified")
    private boolean notified;
    @OneToOne
    @JoinColumn(name = "idpatient")
    private Patient patient;
    @Column(name = "idlabel")
    private int idlabel;

    public TestSchedule(String OPA, String commet, Boolean completed, Boolean notified, int idlabel)
    {
        this.OPA=OPA;
        this.commet=commet;
        this.completed=completed;
        this.idlabel=idlabel;
    }    

    public TestSchedule()
    {}
    
    //getters to retrieve scheduling information for patients

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOPA() {
        return OPA;
    }

    public void setOPA(String OPA) {
        this.OPA = OPA;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Patient getPatient() {
        return patient;
    }

    // public void setIdpatient(int idpatient) {
    //     this.idpatient = idpatient;
    // }

    public int getIdlabel() {
        return idlabel;
    }

    public void setIdlabel(int idlabel) {
        this.idlabel = idlabel;
    }
}
