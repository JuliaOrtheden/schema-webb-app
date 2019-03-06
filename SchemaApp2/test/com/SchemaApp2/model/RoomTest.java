/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
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
public class RoomTest {
    
    public RoomTest() {
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
     * Test of getName method, of class Room.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getName");
        final Room instance = new Room();
        final Field field = instance.getClass().getDeclaredField("name");
        String expResult = "TestRoom";

        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getName();
        assertEquals("field wasn't retrieved properly", result, expResult);

    }

    /**
     * Test of setName method, of class Room.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setName");
        String name = "TestRoom";
        final Room instance = new Room();
        instance.setName(name);
        
        //then
        final Field field = instance.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), name);
        
        
    }

    /**
     * Test of getType method, of class Room.
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchFieldException
     */
    @Test
    public void testGetType() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        System.out.println("getType");
        final Room instance = new Room();
        final Field field = instance.getClass().getDeclaredField("type");
        String expResult = "TestType";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getType();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setType method, of class Room.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetType() throws NoSuchFieldException, IllegalArgumentException ,IllegalAccessException {
        System.out.println("setType");
        String type = "TestType";
        final Room instance = new Room();
        instance.setType(type);
        
        final Field field = instance.getClass().getDeclaredField("type");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), type);
    }

    /**
     * Test of getMaxpeople method, of class Room.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetMaxpeople() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        System.out.println("getMaxpeople");
        final Room instance = new Room();
        final Field field = instance.getClass().getDeclaredField("maxpeople");        
        Short expResult = 10;
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final Short result = instance.getMaxpeople();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setMaxpeople method, of class Room.
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchFieldException
     */
    @Test
    public void testSetMaxpeople() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        System.out.println("setMaxpeople");
        Short maxpeople = 10;
        final Room instance = new Room();
        instance.setMaxpeople(maxpeople);
        
        final Field field = instance.getClass().getDeclaredField("maxpeople");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), maxpeople);
        
    }

    /**
     * Test of getTimeslotCollection method, of class Room.
     */
    @Test
    public void testGetTimeslotCollection() {
        assertTrue(true);
    }

    /**
     * Test of setTimeslotCollection method, of class Room.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetTimeslotCollection() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
                assertTrue(true);
    }

    /**
     * Test of hashCode method, of class Room.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Room instance1 = new Room("TestRoom");
        Room instance2 = new Room("TestRoom");
        Room instanceNotSame = new Room ("NotTestRoom");
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        int result3 = instanceNotSame.hashCode();
        assertEquals("Hashcode should be the same", result1, result2);
        assertNotEquals("Hashcode should not be the same", result1, result3);
        
    }

    /**
     * Test of equals method, of class Room.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Room instance1 = new Room("TestRoom");
        Room instance2 = new Room("TestRoom");
        Room instanceNotSame = new Room ("NotTestRoom");
        assertTrue(instance1.equals(instance2));
        assertFalse(instance1.equals(instanceNotSame));
    }

    /**
     * Test of toString method, of class Room.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Room instance = new Room("TestRoom");
        String expResult = "TestRoom";
        String result = instance.toString();
        assertEquals("Strings should be the same", expResult, result);
        
    }
    
}
