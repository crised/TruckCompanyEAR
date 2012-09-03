package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import entities.TcUser;

@Stateless
public class TcUserFacade extends AbstractFacade<TcUser> {
	private static final Logger LOGGER = Logger.getLogger(TcUserFacade.class);
	
    @PersistenceContext(unitName = "TruckCompanyEJBPU")
    private EntityManager em;

    public TcUserFacade() {
        super(TcUser.class);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(TcUser entity) {
        super.create(entity);
        LOGGER.info("Created user: " + entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void edit(TcUser entity) {
        super.edit(entity);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public TcUser find(Integer id) {
        TcUser found = super.find(id);
        if (found == null) {
        	LOGGER.info("User not found: " + id);
        } else {
        	LOGGER.info("Found user: " + found);
        }
		return found;
    }

    @Override
    public List<TcUser> findAll() {
        List<TcUser> found = super.findAll();
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
        List<TcUser> found = super.findRange(new int[]{from, to});
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
        int count = super.count();
        LOGGER.info("Users in DB:" + count);
		return String.valueOf(count);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
