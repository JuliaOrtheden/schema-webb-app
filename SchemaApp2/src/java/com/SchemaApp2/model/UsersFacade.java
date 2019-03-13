
package com.SchemaApp2.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

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
    
    /**
     * Compares the current user's cid and password with the database cid and password to enable login 
     * @param user
     * @return 
     */
    public Users login(Users user){
        TypedQuery<Users> query = em.createNamedQuery("Users.findByCidAndPassword",Users.class);
        query.setParameter("cid", user.getCid());
        query.setParameter("password", user.getPassword());
        List<Users> resultList = query.getResultList();    
        Users u = resultList.get(0);
        return u;
    }
    
}
