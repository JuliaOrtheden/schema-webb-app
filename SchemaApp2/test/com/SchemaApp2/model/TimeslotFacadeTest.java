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
public class TimeslotFacadeTest {
    
    public TimeslotFacadeTest() {
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
     * Test of create method, of class TimeslotFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Timeslot entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class TimeslotFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Timeslot entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class TimeslotFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Timeslot entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class TimeslotFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        Timeslot expResult = null;
        Timeslot result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class TimeslotFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        List<Timeslot> expResult = null;
        List<Timeslot> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class TimeslotFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        List<Timeslot> expResult = null;
        List<Timeslot> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class TimeslotFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterTimeslotByUser method, of class TimeslotFacade.
     */
    @Test
    public void testFilterTimeslotByUser() throws Exception {
        System.out.println("filterTimeslotByUser");
        Users user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        List<Timeslot> expResult = null;
        List<Timeslot> result = instance.filterTimeslotByUser(user);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeslotsFilteredByRoom method, of class TimeslotFacade.
     */
    @Test
    public void testGetTimeslotsFilteredByRoom() throws Exception {
        System.out.println("getTimeslotsFilteredByRoom");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        List<Timeslot> expResult = null;
        List<Timeslot> result = instance.getTimeslotsFilteredByRoom();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bookTimeslot method, of class TimeslotFacade.
     */
    @Test
    public void testBookTimeslot() throws Exception {
        System.out.println("bookTimeslot");
        Timeslot timeslot = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        TimeslotFacade instance = (TimeslotFacade)container.getContext().lookup("java:global/classes/TimeslotFacade");
        instance.bookTimeslot(timeslot);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
