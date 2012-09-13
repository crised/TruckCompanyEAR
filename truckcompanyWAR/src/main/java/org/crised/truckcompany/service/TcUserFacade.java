package org.crised.truckcompany.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.crised.truckcompany.model.TcUser;
import org.crised.truckcompany.util.QueryUtil;
import org.jboss.logging.Logger;



@Stateless
public class TcUserFacade {
	
	private static final Logger LOGGER = Logger.getLogger(TcUserFacade.class);
	
    @PersistenceContext(unitName = "TruckCompanyEJBPU")
    private EntityManager em;

    public void create(TcUser entity) {
        em.persist(entity);
        LOGGER.info("Created user: " + entity);
    }

    public void edit(TcUser entity) {
        em.merge(entity);
    }

    public void remove(TcUser entity) {
        entity.setDeleted(true);
        entity.setDeletedDate(new Date());
        em.persist(entity);
    }

    public TcUser find(Integer id) {
    	TypedQuery<TcUser> query = em.createQuery("SELECT u FROM TcUser u WHERE u.id = :id AND u.deleted = FALSE", TcUser.class);
    	query.setParameter("id", id);    	
        TcUser found = QueryUtil.getSingleResult(query.getResultList());
        if (found == null) {
        	LOGGER.info("User not found: " + id);
        } else {
        	LOGGER.info("Found user: " + found);
        }
		return found;
    }
    
    public TcUser find(String username) {
    	TypedQuery<TcUser> query = em.createQuery("SELECT u FROM TcUser u WHERE u.username = :username AND u.deleted = FALSE", TcUser.class);
    	query.setParameter("username", username);    	
        return QueryUtil.getSingleResult(query.getResultList());
    }

    public List<TcUser> findAll() {
    	TypedQuery<TcUser> query = em.createQuery("SELECT u FROM TcUser u WHERE u.deleted = FALSE", TcUser.class);
        List<TcUser> found = query.getResultList();
        if (found.size() == 0) {
        	LOGGER.info("No users found");
        } else {
        	LOGGER.info("found users");
        	for (int i = 0; i < found.size(); i++) {
        		LOGGER.info(found.get(i));
        	}
        }
		return found;
    }

    public List<TcUser> findRange(Integer from, Integer to) {
    	TypedQuery<TcUser> query = em.createQuery("SELECT u FROM TcUser u WHERE u.deleted = FALSE", TcUser.class);
    	query.setMaxResults(to - from);
        query.setFirstResult(from);
        List<TcUser> found = query.getResultList();
        if (found.size() == 0) {
        	LOGGER.info("No users found");
        } else {
        	LOGGER.info("found users");
        	for (TcUser user : found) {
        		LOGGER.info(user);
        	}
        }
		return found;
    }

    public String countREST() {
    	TypedQuery<Long> query = em.createQuery("SELECT COUNT(u.id) FROM TcUser u WHERE u.deleted = FALSE", Long.class);
        int count = query.getSingleResult().intValue();
        LOGGER.info("Users in DB:" + count);
		return String.valueOf(count);
    }
}
