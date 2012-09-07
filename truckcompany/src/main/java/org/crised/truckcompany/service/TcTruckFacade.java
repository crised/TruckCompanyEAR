package org.crised.truckcompany.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crised.truckcompany.model.TcTruck;

@Stateless
public class TcTruckFacade extends AbstractFacade<TcTruck> {
	
	//@PersistenceContext(unitName = "TruckCompanyEJBPU")
	@Inject
    private EntityManager em;

    public TcTruckFacade() {
        super(TcTruck.class);
    }

    @Override
    public void create(TcTruck entity) {
        super.create(entity);
    }

    @Override
    public void edit(TcTruck entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public TcTruck find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<TcTruck> findAll() {
        return super.findAll();
    }

    public List<TcTruck> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
}
