/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.lang.reflect.Field;
import java.util.Collection;
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
public class UsersTest {
    
    public UsersTest() {
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
     * Test of getCid method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetCid() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getCid");
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("cid");
        String expResult = "TestCid";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getCid();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setCid method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetCid() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setCid");
        String cid = "TestCid";
        final Users instance = new Users();
        instance.setCid(cid);
        
        //then
        final Field field = instance.getClass().getDeclaredField("cid");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), cid);
    }

    /**
     * Test of getFirstname method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetFirstname() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getFirstname");
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("firstname");
        String expResult = "TestName";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getFirstname();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setFirstname method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetFirstname() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setFirstname");
        String firstname = "TestName";
        final Users instance = new Users();
        instance.setFirstname(firstname);
        
        //then
        final Field field = instance.getClass().getDeclaredField("firstname");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), firstname);
    }

    /**
     * Test of getLastname method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetLastname() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("lastname");
        String expResult = "TestName";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getLastname();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setLastname method, of class Users.
     */
    @Test
    public void testSetLastname() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setLastname");
        String lastname = "TestName";
        final Users instance = new Users();
        instance.setLastname(lastname);
        
        //then
        final Field field = instance.getClass().getDeclaredField("lastname");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), lastname);
    }

    /**
     * Test of getEmail method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetEmail() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getEmail");
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("email");
        String expResult = "TestEmail";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getEmail();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setEmail method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetEmail() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setEmail");
        String email = "TestEmail";
        final Users instance = new Users();
        instance.setEmail(email);
        
        //then
        final Field field = instance.getClass().getDeclaredField("email");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), email);
    }

    /**
     * Test of getPassword method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getPassword");
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("password");
        String expResult = "TestPassword";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getPassword();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setPassword method, of class Users.
     */
    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setPassword");
        String password = "TestPassword";
        final Users instance = new Users();
        instance.setPassword(password);
        
        //then
        final Field field = instance.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), password);
    }

    /**
     * Test of getUsertype method, of class Users.
     */
    @Test
    public void testGetUsertype() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getUsertype");
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("usertype");
        String expResult = "TestType";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getUsertype();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setUsertype method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetUsertype() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setUsertype");
        String usertype = "TestType";
        final Users instance = new Users();
        instance.setUsertype(usertype);
        
        //then
        final Field field = instance.getClass().getDeclaredField("usertype");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), usertype);
    }

    /**
     * Test of getDivision method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetDivision() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("getDivision");
        final Users instance = new Users();
        final Field field = instance.getClass().getDeclaredField("division");
        String expResult = "TestDivision";
        
        field.setAccessible(true);
        field.set(instance, expResult);
        
        final String result = instance.getDivision();
        assertEquals("field wasn't retrieved properly", result, expResult);
    }

    /**
     * Test of setDivision method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testSetDivision() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("setDivision");
        String division = "TestDivision";
        final Users instance = new Users();
        instance.setDivision(division);
        
        //then
        final Field field = instance.getClass().getDeclaredField("division");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(instance), division);
    }

    /**
     * Test of getTimeslotCollection method, of class Users.
     */
    @Test
    public void testGetTimeslotCollection() {
        assertTrue(true);
    }

    /**
     * Test of setTimeslotCollection method, of class Users.
     */
    @Test
    public void testSetTimeslotCollection() {
        assertTrue(true);
    }

    /**
     * Test of hashCode method, of class Users.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Users instance1 = new Users("TestUser");
        Users instance2 = new Users("TestUser");
        Users instanceNotSame = new Users ("NotTestUser");
        int result1 = instance1.hashCode();
        int result2 = instance2.hashCode();
        int result3 = instanceNotSame.hashCode();
        assertEquals("Hashcode should be the same", result1, result2);
        assertNotEquals("Hashcode should not be the same", result1, result3);
    }

    /**
     * Test of equals method, of class Users.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Users instance1 = new Users("TestUser");
        Users instance2 = new Users("TestUser");
        Users instanceNotSame = new Users ("NotTestUser");
        assertTrue(instance1.equals(instance2));
        assertFalse(instance1.equals(instanceNotSame));
    }

    /**
     * Test of toString method, of class Users.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testToString() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("toString");
        Users instance = new Users();
        final Field field1 = instance.getClass().getDeclaredField("firstname");
        final Field field2 = instance.getClass().getDeclaredField("lastname");

        field1.setAccessible(true);
        field2.setAccessible(true);
        field1.set(instance, "Test");
        field2.set(instance, "User");
        
        
        String expResult = "Test User";
        String result = instance.toString();
        assertEquals("Strings should be the same", expResult, result);
    }
    
}
