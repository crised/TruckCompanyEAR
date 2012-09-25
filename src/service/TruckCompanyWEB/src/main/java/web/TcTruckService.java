package web;

import entities.TcTruck;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

import service.TcTruckFacade;

@Stateless
@Path("entities.tctruck")
//@RolesAllowed({ SecurityRole.USER })
public class TcTruckService {
	
	@EJB
	private TcTruckFacade facade;

    @POST
    @Consumes({"application/json"})
    public void create(TcTruck entity) {
        facade.create(entity);
    }

    @PUT
    @Consumes({"application/json"})
    public void edit(TcTruck entity) {
        facade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
    	TcTruck entity = facade.find(id);
    	if (entity == null) {
    		throw new IllegalArgumentException();
    	}
        facade.remove(entity);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public TcTruck find(@PathParam("id") Integer id) {
        return facade.find(id);
    }

    @GET
    @Produces({"application/json"})
    public Map<String, List<TcTruck>> findAll() {
        return Collections.singletonMap("trucks",facade.findAll());
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<TcTruck> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return facade.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return facade.countREST();
    }
}
