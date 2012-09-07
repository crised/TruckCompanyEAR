package service;

import entities.TcTruck;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import util.QueryUtil;

@Stateless
public class TcTruckFacade {
	
    @PersistenceContext(unitName = "TruckCompanyEJBPU")
    private EntityManager em;

    public void create(TcTruck entity) {
        em.persist(entity);
    }

    public void edit(TcTruck entity) {
        em.merge(entity);
    }

    public void remove(Integer id) {
    	TypedQuery<TcTruck> query = em.createQuery("SELECT t FROM TcTruck t WHERE t.id = :id AND t.deleted = FALSE", TcTruck.class);
    	query.setParameter("id", id);
    	TcTruck entity = query.getSingleResult();
        entity.setDeleted(true);
        entity.setDeletedDate(new Date());
        em.persist(entity);
    }

    public TcTruck find(Integer id) {
    	TypedQuery<TcTruck> query = em.createQuery("SELECT t FROM TcTruck t WHERE t.id = :id AND t.deleted = FALSE", TcTruck.class);
    	query.setParameter("id", id);    	
        return QueryUtil.getSingleResult(query.getResultList());
    }

    public List<TcTruck> findAll() {
    	TypedQuery<TcTruck> query = em.createQuery("SELECT t FROM TcTruck t WHERE t.deleted = FALSE", TcTruck.class);
        return query.getResultList();
    }

    public List<TcTruck> findRange(Integer from, Integer to) {
    	TypedQuery<TcTruck> query = em.createQuery("SELECT t FROM TcTruck t WHERE t.deleted = FALSE", TcTruck.class);
    	query.setMaxResults(to - from);
        query.setFirstResult(from);
        return query.getResultList();
    }

    public String countREST() {
    	TypedQuery<Long> query = em.createQuery("SELECT COUNT(t.id) FROM TcTruck t WHERE t.deleted = FALSE", Long.class);
        return String.valueOf(query.getSingleResult().intValue());
    }    
}
