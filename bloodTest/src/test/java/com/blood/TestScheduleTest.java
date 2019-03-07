package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.blood.pojo.TestSchedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class TestScheduleTest {
    

    @Test
    public void testGetId() {  
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        assertEquals(test.getId(), 0);
    }

    @Test
    public void testSetId() {
        
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        test.setId(1);
        assertEquals(test.getId(), 1);
    }

    @Test
    public void testGetOPA() {  
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        assertEquals(test.getOPA(), "tOPA");
    }

    @Test
    public void testSetOPA() {
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        test.setOPA("changedOPA");
        assertEquals(test.getOPA(), "changedOPA");
    }

    @Test
    public void testisCompleted() {  
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        assertEquals(test.getOPA(), true);
    }

    @Test
    public void testSetCompleted() {
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        test.setCompleted(false);
        assertEquals(test.isCompleted(), false);
    }

    @Test
    public void testGetCommet() {  
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        assertEquals(test.getCommet(), true);
    }

    @Test
    public void testSetCommet() {
        TestSchedule test = new TestSchedule("tOPA", "tCommet", true, false, 0);
        test.setCommet("false");
        assertEquals(test.getCommet(), false);
    }



    @Test
    public void testEmptyTestSchedule() {   
        TestSchedule test = new TestSchedule();
        assertEquals(test.getId(), 0);
        assertEquals(test.getOPA(), null);
        assertEquals(test.isCompleted(), false);
        assertEquals(test.getCommet(), null);
    }
    

}