/**
 * 
 * A Class containing the carry over information for patient appointments
 * 
 * @author Yeshvanth Prabakar, Patrick Whyte, Swapnil Paul, Zhenjie Jiang, Yilei Liang and Tao Lin
 * @version 2019.02.21
 * 
 */

package com.blood.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
@Table(name = "test_carried_over")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class TestCarriedOver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtest_carried_over")
    private int idtest_carried_over;
    @Column(name = "OPA")
    private String OPA;
    @Column(name = "date")
    private String date;
    @Column(name = "next_schedule")
    private String nextSchedule;
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

    // getters and setters for carrying over blood test information

    public TestCarriedOver(int id, String OPA, String date, String nextSchedule, boolean isCompleted, String commet,
            boolean notified, int idpatient, int idlabel) {
        super();
        this.idtest_carried_over = id;
        this.OPA = OPA;
        this.date = date;
        this.nextSchedule = nextSchedule;
        this.completed = isCompleted;
        this.commet = commet;
        this.notified = notified;
        this.idpatient = idpatient;
        this.idlabel = idlabel;
    }

    public TestCarriedOver() {
        super();
    }

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

    public String getNextSchedule() {
        return nextSchedule;
    }

    public void setNextSchedule(String nextSchedule) {
        this.nextSchedule = nextSchedule;
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
