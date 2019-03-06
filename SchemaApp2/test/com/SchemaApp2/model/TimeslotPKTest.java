/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan Wennerbeck
 */
public class TimeslotPKTest {
    
    public TimeslotPKTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDate method, of class TimeslotPK.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        TimeslotPK instance = new TimeslotPK();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class TimeslotPK.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        TimeslotPK instance = new TimeslotPK();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class TimeslotPK.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        TimeslotPK instance = new TimeslotPK();
        Date expResult = null;
        Date result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class TimeslotPK.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Date time = null;
        TimeslotPK instance = new TimeslotPK();
        instance.setTime(time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoom method, of class TimeslotPK.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");
        TimeslotPK instance = new TimeslotPK();
        String expResult = "";
        String result = instance.getRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoom method, of class TimeslotPK.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        String room = "";
        TimeslotPK instance = new TimeslotPK();
        instance.setRoom(room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TimeslotPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TimeslotPK instance = new TimeslotPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TimeslotPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        TimeslotPK instance = new TimeslotPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TimeslotPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TimeslotPK instance = new TimeslotPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
