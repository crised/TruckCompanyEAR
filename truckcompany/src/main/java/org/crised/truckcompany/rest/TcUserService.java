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

import org.crised.truckcompany.model.TcUser;
import org.crised.truckcompany.service.TcUserFacade;
import org.crised.truckcompany.util.SecurityUtil;


@Stateless
@Path("entities.tcuser")
@RolesAllowed({ SecurityRole.USER })
public class TcUserService {
	
	@EJB
	private TcUserFacade facade;
	
    @POST
    @Consumes({"application/json"})
    public void create(TcUser entity) {
    	String hash = SecurityUtil.hash(entity.getPassword());
    	entity.setPassword(hash);
    	facade.create(entity);
    }

    @PUT
    @Consumes({"application/json"})
    public void edit(TcUser entity) {
        facade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        facade.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public TcUser find(@PathParam("id") Integer id) {
    	return facade.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<TcUser> findAll() {
        return facade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<TcUser> findRange(Integer from, Integer to) {
        return facade.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
    	return facade.countREST();
    }
}
