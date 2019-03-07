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
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetDate() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getDate");
        final TimeslotPK instance = new TimeslotPK();
        final Field field = instance.getClass().getDeclaredField("date");
        Date expResult = new Date();
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final Date result = instance.getDate();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setDate method, of class TimeslotPK.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetDate() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setDate");
        Date date = new Date();
        final TimeslotPK instance = new TimeslotPK();
        instance.setDate(date);
        
        //then
        final Field field = instance.getClass().getDeclaredField("date");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), date);
    }

    /**
     * Test of getTime method, of class TimeslotPK.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetTime() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getTime");
        final TimeslotPK instance = new TimeslotPK();
        final Field field = instance.getClass().getDeclaredField("time");
        Date expResult = new Date();
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final Date result = instance.getTime();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setTime method, of class TimeslotPK.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetTime() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setTime");
        Date time = new Date();
        final TimeslotPK instance = new TimeslotPK();
        instance.setTime(time);
        
        //then
        final Field field = instance.getClass().getDeclaredField("time");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), time);
    }

    /**
     * Test of getRoom method, of class TimeslotPK.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetRoom() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getRoom");
        final TimeslotPK instance = new TimeslotPK();
        final Field field = instance.getClass().getDeclaredField("room");
        String expResult = "TestRoom";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getRoom();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setRoom method, of class TimeslotPK.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetRoom() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setRoom");
        String room = "TestRoom";
        final TimeslotPK instance = new TimeslotPK();
        instance.setRoom(room);
        
        //then
        final Field field = instance.getClass().getDeclaredField("room");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), room);
    }

    /**
     * Test of hashCode method, of class TimeslotPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        String room = "TestRoom";
        String roomNotTheSame = "NotTestRoom";
        Date date = new Date();
        Date time = new Date();
        TimeslotPK instance1 = new TimeslotPK(date, time, room);
        TimeslotPK instance2 = new TimeslotPK(date, time, room);
        TimeslotPK instanceNotSame = new TimeslotPK(date, time, roomNotTheSame);
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        int result3 = instanceNotSame.hashCode();
        assertEquals("Hashcode should be the same", result1, result2);
        assertNotEquals("Hashcode should not be the same", result1, result3);
    }

    /**
     * Test of equals method, of class TimeslotPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String room = "TestRoom";
        String roomNotTheSame = "NotTestRoom";
        Date date = new Date();
        Date time = new Date();
        TimeslotPK instance1 = new TimeslotPK(date, time, room);
        TimeslotPK instance2 = new TimeslotPK(date, time, room);
        TimeslotPK instanceNotSame = new TimeslotPK(date, time, roomNotTheSame);
        
        assertTrue(instance1.equals(instance2));
        assertFalse(instance1.equals(instanceNotSame));
    }

    /**
     * Test of toString method, of class TimeslotPK.
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
        
        String expResult = (date + " " + time + " " + room);
        String result = instance.toString();
        assertEquals("Strings should be the same", expResult, result);
    }
    
}
