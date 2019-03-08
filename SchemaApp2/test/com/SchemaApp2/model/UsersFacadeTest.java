/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
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
public class UsersFacadeTest {
    
    public UsersFacadeTest() {
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
     * Test of create method, of class UsersFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Users entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UsersFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Users entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UsersFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Users entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UsersFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        Users expResult = null;
        Users result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UsersFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        List<Users> expResult = null;
        List<Users> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class UsersFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        List<Users> expResult = null;
        List<Users> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class UsersFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UsersFacade.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        Users user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersFacade instance = (UsersFacade)container.getContext().lookup("java:global/classes/UsersFacade");
        Users expResult = null;
        Users result = instance.login(user);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
