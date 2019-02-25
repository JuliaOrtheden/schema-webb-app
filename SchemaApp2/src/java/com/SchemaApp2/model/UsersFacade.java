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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author juliaortheden
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "SchemaApp2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users login(Users user){
        //em.getTransaction().begin();
        TypedQuery<Users> query = em.createNamedQuery("Users.findByCidAndPassword",Users.class);
        query.setParameter("cid", user.getCid());
        query.setParameter("password", user.getPassword());
        List<Users> resultList = query.getResultList();    
        Users u = resultList.get(0);
        return u;
    }
    
}
