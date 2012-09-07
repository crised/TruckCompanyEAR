package org.crised.truckcompany.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crised.truckcompany.model.TcConsumption;

@Stateless
public class TcConsumptionFacade extends AbstractFacade<TcConsumption> {
	
    //@PersistenceContext(unitName = "TruckCompanyEJBPU")
	@Inject
    private EntityManager em;

    public TcConsumptionFacade() {
        super(TcConsumption.class);
    }

    @Override
    public void create(TcConsumption entity) {
        super.create(entity);
    }

    @Override
    public void edit(TcConsumption entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public TcConsumption find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<TcConsumption> findAll() {
        return super.findAll();
    }

    public List<TcConsumption> findRange(Integer from, Integer to) {
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
