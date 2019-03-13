
package com.SchemaApp2.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class TimeslotFacade extends AbstractFacade<Timeslot> {

    @PersistenceContext(unitName = "SchemaApp2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Filters bookings by a user
     * @param user
     * @return 
     */
    public List<Timeslot> filterTimeslotByUser(Users user){
        TypedQuery<Timeslot> query = em.createNamedQuery("Timeslot.filterTimeslotByUser", Timeslot.class);
        query.setParameter("usercid", user.getCid());
        List<Timeslot> queryResult = query.getResultList();
        return queryResult;
    }
    
    /**
     * Gets all booked time slots
     * @return 
     */
    public List<Timeslot> getBookedTimeslots(){
        TypedQuery<Timeslot> query = em.createNamedQuery("Timeslot.findAll", Timeslot.class);
        List<Timeslot> queryResult = query.getResultList();
        return queryResult;
    }

    public TimeslotFacade() {
        super(Timeslot.class);
    }
    
    /**
     * Gets all booked slots for a certain room
     * @return 
     */
     public List<Timeslot> getTimeslotsFilteredByRoom(){
        TypedQuery<Timeslot> query = em.createNamedQuery("Timeslot.findByRoom",Timeslot.class);
        List<Timeslot> resultList = query.getResultList();    
        return resultList;
    }
     
    
}
