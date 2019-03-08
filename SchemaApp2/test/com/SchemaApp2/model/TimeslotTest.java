/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.lang.reflect.Field;
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
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetTimeslotPK() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getTimeslotPK");
        final Timeslot instance = new Timeslot();
        final Field field = instance.getClass().getDeclaredField("timeslotPK");
        String room = "TestRoom";
        Date date = new Date();
        Date time = new Date();
        TimeslotPK expResult = new TimeslotPK(date, time, room);
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final TimeslotPK result = instance.getTimeslotPK();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setTimeslotPK method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetTimeslotPK() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setTimeslotPK");
        String room = "TestRoom";
        Date date = new Date();
        Date time = new Date();
        final TimeslotPK timeslotPK = new TimeslotPK(date, time, room);
        final Timeslot instance = new Timeslot();
        instance.setTimeslotPK(timeslotPK);
        
        //then
        final Field field = instance.getClass().getDeclaredField("timeslotPK");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), timeslotPK);
    }

    /**
     * Test of getDescription method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetDescription() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getDescription");
        final Timeslot instance = new Timeslot();
        final Field field = instance.getClass().getDeclaredField("description");
        String expResult = "TestDescription";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getDescription();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setDescription method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetDescription() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setDescription");
        String description = "TestName";
        final Timeslot instance = new Timeslot();
        instance.setDescription(description);
        
        //then
        final Field field = instance.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), description);
    }

    /**
     * Test of getRoom1 method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetRoom1() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getRoom1");
        final Timeslot instance = new Timeslot();
        final Field field = instance.getClass().getDeclaredField("room1");
        Room expResult = new Room("TestRoom");
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final Room result = instance.getRoom1();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setRoom1 method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetRoom1() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setRoom1");
        Room room = new Room("TestRoom");
        final Timeslot instance = new Timeslot();
        instance.setRoom1(room);
        
        //then
        final Field field = instance.getClass().getDeclaredField("room1");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), room);
    }

    /**
     * Test of getUsers method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetUsers() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getUsers");
        final Timeslot instance = new Timeslot();
        final Field field = instance.getClass().getDeclaredField("users");
        Users expResult = new Users("TestUser");
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final Users result = instance.getUsers();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setUsers method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetUsers() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setUsers");
        Users user = new Users("TestUser");
        final Timeslot instance = new Timeslot();
        instance.setUsers(user);
        
        //then
        final Field field = instance.getClass().getDeclaredField("users");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), user);
    }

    /**
     * Test of hashCode method, of class Timeslot.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String room = "TestRoom";
        String roomNotTheSame = "NotTestRoom";
        Date date = new Date();
        Date time = new Date();
        TimeslotPK timeslotPK1 = new TimeslotPK(date, time, room);
        TimeslotPK timeslotPK2 = new TimeslotPK(date, time, room);
        TimeslotPK timeslotPK3 = new TimeslotPK(date, time, roomNotTheSame);

        Timeslot instance1 = new Timeslot(timeslotPK1);
        Timeslot instance2 = new Timeslot(timeslotPK2);
        Timeslot instanceNotSame = new Timeslot(timeslotPK3);
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        int result3 = instanceNotSame.hashCode();
        assertEquals("Hashcode should be the same", result1, result2);
        assertNotEquals("Hashcode should not be the same", result1, result3);
    }

    /**
     * Test of equals method, of class Timeslot.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String room = "TestRoom";
        String roomNotTheSame = "NotTestRoom";
        Date date = new Date();
        Date time = new Date();
        TimeslotPK timeslotPK1 = new TimeslotPK(date, time, room);
        TimeslotPK timeslotPK2 = new TimeslotPK(date, time, room);
        TimeslotPK timeslotPK3 = new TimeslotPK(date, time, roomNotTheSame);

        Timeslot instance1 = new Timeslot(timeslotPK1);
        Timeslot instance2 = new Timeslot(timeslotPK2);
        Timeslot instanceNotSame = new Timeslot(timeslotPK3);
        assertTrue(instance1.equals(instance2));
        assertFalse(instance1.equals(instanceNotSame));
    }

    /**
     * Test of toString method, of class Timeslot.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testToString() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("toString");
        TimeslotPK instance = new TimeslotPK();
        final Field field1 = instance.getClass().getDeclaredField("date");
        final Field field2 = instance.getClass().getDeclaredField("time");
        final Field field3 = instance.getClass().getDeclaredField("room");

        Date date = new Date();
        Date time = new Date();
        String room = "TestRoom";
        field1.setAccessible(true);
        field2.setAccessible(true);
        field3.setAccessible(true);
        field1.set(instance, date);
        field2.set(instance, time);
        field3.set(instance, room);
        
        Timeslot testInstance = new Timeslot(instance);
        String expResult = (date + " " + time + " " + room);
        String result = testInstance.toString();
        assertEquals("Strings should be the same", expResult, result);
    }
    
}
