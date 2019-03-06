/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

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
public class TimeslotTest {
    
    public TimeslotTest() {
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
     * Test of getTimeslotPK method, of class Timeslot.
     */
    @Test
    public void testGetTimeslotPK() {
        System.out.println("getTimeslotPK");
        Timeslot instance = new Timeslot();
        TimeslotPK expResult = null;
        TimeslotPK result = instance.getTimeslotPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeslotPK method, of class Timeslot.
     */
    @Test
    public void testSetTimeslotPK() {
        System.out.println("setTimeslotPK");
        TimeslotPK timeslotPK = null;
        Timeslot instance = new Timeslot();
        instance.setTimeslotPK(timeslotPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Timeslot.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Timeslot instance = new Timeslot();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Timeslot.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Timeslot instance = new Timeslot();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoom1 method, of class Timeslot.
     */
    @Test
    public void testGetRoom1() {
        System.out.println("getRoom1");
        Timeslot instance = new Timeslot();
        Room expResult = null;
        Room result = instance.getRoom1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoom1 method, of class Timeslot.
     */
    @Test
    public void testSetRoom1() {
        System.out.println("setRoom1");
        Room room1 = null;
        Timeslot instance = new Timeslot();
        instance.setRoom1(room1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Timeslot.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Timeslot instance = new Timeslot();
        Users expResult = null;
        Users result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class Timeslot.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        Users users = null;
        Timeslot instance = new Timeslot();
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Timeslot.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Timeslot instance = new Timeslot();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Timeslot.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Timeslot instance = new Timeslot();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Timeslot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Timeslot instance = new Timeslot();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
