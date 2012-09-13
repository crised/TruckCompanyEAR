package org.crised.truckcompany.rest;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.crised.truckcompany.model.TcConsumption;
import org.crised.truckcompany.model.TcUser;
import org.crised.truckcompany.service.TcAuditFacade;
import org.crised.truckcompany.service.TcConsumptionFacade;
import org.crised.truckcompany.service.TcUserFacade;


@Stateless
@Path("entities.tcconsumption")
@RolesAllowed({ SecurityRole.USER })
public class TcConsumptionService {
		
	@EJB
	private TcConsumptionFacade facade;

	@EJB
	private TcUserFacade userFacade;

	@EJB
	private TcAuditFacade auditFacade;

    @POST
    @Consumes({"application/json"})
    public void create(@Context SecurityContext context, TcConsumption entity) {    	
    	facade.create(entity);
    	
    	TcUser user = userFacade.find(context.getUserPrincipal().getName());
    	if (user == null) {
    		throw new IllegalArgumentException();
    	}
    	auditFacade.auditCreate(user, entity);
    }

    @PUT
    @Consumes({"application/json"})
    public void edit(TcConsumption entity) {
        facade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@Context SecurityContext context, @PathParam("id") Integer id) {
    	TcConsumption consumption = facade.find(id);
    	if (consumption == null) {
    		throw new IllegalArgumentException();
    	}    	
        facade.remove(consumption);
        
        TcUser user = userFacade.find(context.getUserPrincipal().getName());
    	if (user == null) {
    		throw new IllegalArgumentException();
    	}
    	auditFacade.auditDelete(user, consumption);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public TcConsumption find(@PathParam("id") Integer id) {
        return facade.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<TcConsumption> findAll() {
        return facade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<TcConsumption> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return facade.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return facade.countREST();
    }
}
