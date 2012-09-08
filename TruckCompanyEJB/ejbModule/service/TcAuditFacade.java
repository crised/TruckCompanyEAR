package service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.TcAudit;
import entities.TcAudit.Action;
import entities.TcConsumption;
import entities.TcUser;

@Stateless
public class TcAuditFacade {
	
    @PersistenceContext(unitName = "TruckCompanyEJBPU")
    private EntityManager em;
    
    public void auditCreate(TcUser user, TcConsumption consumption) {
    	audit(user, consumption, Action.CREATE);
    }
    
    public void auditDelete(TcUser user, TcConsumption consumption) {
    	audit(user, consumption, Action.DELETE);
    }
    
    private void audit(TcUser user, TcConsumption consumption, Action action) {
    	TcAudit audit = new TcAudit();
    	audit.setAction(action);
    	audit.setDate(new Date());
    	audit.setUser(user);
    	audit.setConsumption(consumption);
    	em.persist(audit);
    }
}
