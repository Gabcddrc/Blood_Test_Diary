package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.TestCarriedOver;
import org.junit.Test;

public class TestCarriedOverTests {

    @Test
    public void testGetID() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getIdtest_carried_over(), 1);
    }

    @Test
    public void testSetID() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setIdtest_carried_over(2);
        assertEquals(testCarriedOver.getIdtest_carried_over(), 2);
    }

    @Test
    public void testGetOPA() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getOPA(), "tOPA");
    }

    @Test
    public void testSetOPA() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setOPA("changedOPA");
        assertEquals(testCarriedOver.getOPA(), "changedOPA");
    }

    @Test
    public void testGetDate() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getDate(), "tDate");
    }

    @Test
    public void testSetDate() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setDate("changedDate");
        assertEquals(testCarriedOver.getDate(), "changedDate");
    }

    @Test
    public void testGetNextSchedule() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getDate(), "tNextSchedule");
    }

    @Test
    public void testSetNextSchedule() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setNextSchedule("changedNextSchedule");
        assertEquals(testCarriedOver.getNextSchedule(), "changedNextSchedule");
    }

    @Test
    public void testIsCompleted() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.isCompleted(), true);
    }

    @Test
    public void testSetCompleted() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setCompleted(false);
        assertEquals(testCarriedOver.isCompleted(), false);
    }

    @Test
    public void testGetCommet() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getCommet(), "tCommet");
    }

    @Test
    public void testSetCommet() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setCommet("changedCommet");
        assertEquals(testCarriedOver.getCommet(), "changedCommet");
    }

    @Test
    public void testIsNotified() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.isNotified(), true);
    }

    @Test
    public void testSetNotified() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setNotified(false);
        assertEquals(testCarriedOver.isNotified(), false);
    }

    @Test
    public void testGetIdpatient() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getIdpatient(), 1);
    }

    @Test
    public void testSetIdpatient() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setIdpatient(2);
        assertEquals(testCarriedOver.getIdpatient(), 2);
    }

    @Test
    public void testGetIdLabel() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        assertEquals(testCarriedOver.getIdlabel(), 1);
    }

    @Test
    public void testSetIdLabel() {
        TestCarriedOver testCarriedOver = new TestCarriedOver(1, "tOPA", "tDate", "tNextSchedule", true, "tCommet",
                true, 1, 1);
        testCarriedOver.setIdlabel(2);
        assertEquals(testCarriedOver.getIdlabel(), 2);
    }

    @Test
    public void testEmptyDetails() {
        TestCarriedOver testCarriedOver = new TestCarriedOver();
        assertEquals(testCarriedOver.getIdtest_carried_over(), 0);
        assertEquals(testCarriedOver.getOPA(), null);
        assertEquals(testCarriedOver.getDate(), null);
        assertEquals(testCarriedOver.getNextSchedule(), null);
        assertEquals(testCarriedOver.isCompleted(), null);
        assertEquals(testCarriedOver.getCommet(), null);
        assertEquals(testCarriedOver.isNotified(), null);
        assertEquals(testCarriedOver.getIdpatient(), 0);
        assertEquals(testCarriedOver.getIdlabel(), 0);
    }

}