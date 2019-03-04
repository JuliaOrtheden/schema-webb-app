/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author juliaortheden
 */
@Stateless
public class TimeslotFacade extends AbstractFacade<Timeslot> {

    @PersistenceContext(unitName = "SchemaApp2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Timeslot> filterTimeslotByUser(Users user){
        TypedQuery<Timeslot> query = em.createNamedQuery("Timeslot.filterTimeslotByUser", Timeslot.class);
        query.setParameter("usercid", user.getCid());
        List<Timeslot> queryResult = query.getResultList();
        return queryResult;
    }

    public TimeslotFacade() {
        super(Timeslot.class);
    }
    
     public List<Timeslot> getTimeslotsFilteredByRoom(){
        //em.getTransaction().begin();
        TypedQuery<Timeslot> query = em.createNamedQuery("Timeslot.findByRoom",Timeslot.class);
        List<Timeslot> resultList = query.getResultList();    
        return resultList;
    }
    
    public void bookTimeslot(Timeslot timeslot){
        System.out.println("Into query");
        Query query = em.createNativeQuery("INSERT INTO Timeslot(date,time,room,description,users) VALUES(:date,:time,:room,:description,:users)",Timeslot.class);
        query.setParameter("date", timeslot.getTimeslotPK().getDate());
        query.setParameter("time", timeslot.getTimeslotPK().getTime());
        query.setParameter("room", timeslot.getTimeslotPK().getRoom());
        query.setParameter("description", timeslot.getDescription());
        query.setParameter("users", timeslot.getUsers());
    }
     
    
}
