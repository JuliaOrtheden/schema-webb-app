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
    
}
