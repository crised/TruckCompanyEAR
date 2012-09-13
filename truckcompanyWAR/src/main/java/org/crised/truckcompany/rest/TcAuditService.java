package org.crised.truckcompany.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.crised.truckcompany.model.TcAudit;
import org.crised.truckcompany.service.TcAuditFacade;


@Stateless
@Path("entities.tcaudit")
@RolesAllowed({ SecurityRole.USER })
public class TcAuditService {
	
	@EJB
	private TcAuditFacade facade;
	
	@GET
    @Produces({"application/json"})
    public List<TcAudit> findAll() {
        return facade.findAll();
    }
}
