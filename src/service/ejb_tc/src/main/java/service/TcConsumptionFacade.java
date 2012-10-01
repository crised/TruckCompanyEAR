package service;

import entities.TcConsumption;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import util.QueryUtil;

@Stateless
public class TcConsumptionFacade {
	
    @PersistenceContext(unitName = "TruckCompanyEJBPU")
    private EntityManager em;

    public void create(TcConsumption entity) {
        em.persist(entity);
    }

    public void edit(TcConsumption entity) {
        em.merge(entity);
    }

    public void remove(TcConsumption entity) {
        entity.setDeleted(true);
        entity.setDeletedDate(new Date());
        em.persist(entity);
    }

    public TcConsumption find(Integer id) {
    	TypedQuery<TcConsumption> query = em.createQuery("SELECT c FROM TcConsumption c WHERE c.id = :id AND c.deleted = FALSE", TcConsumption.class);
    	query.setParameter("id", id);    	
        return QueryUtil.getSingleResult(query.getResultList());
    }

    public List<TcConsumption> findAll() {
    	TypedQuery<TcConsumption> query = em.createQuery("SELECT c FROM TcConsumption c WHERE c.deleted = FALSE", TcConsumption.class);
        return query.getResultList();
    }

    public List<TcConsumption> findRange(Integer from, Integer to) {
    	TypedQuery<TcConsumption> query = em.createQuery("SELECT c FROM TcConsumption c WHERE c.deleted = FALSE", TcConsumption.class);
    	query.setMaxResults(to - from);
        query.setFirstResult(from);
        return query.getResultList();
    }

    public String countREST() {
    	TypedQuery<Long> query = em.createQuery("SELECT COUNT(c.id) FROM TcConsumption c WHERE c.deleted = FALSE", Long.class);
        return String.valueOf(query.getSingleResult().intValue());
    }    
}
