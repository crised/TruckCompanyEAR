package web;
import java.util.List;
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
import service.TcUserFacade;
import util.SecurityUtil;
import entities.TcUser;

@Stateless
@Path("entities.tcuser")
public class TcUserService {
	
	@EJB
	private TcUserFacade facade;
	
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(TcUser entity) {
    	String hash = SecurityUtil.hash(entity.getPassword());
    	entity.setPassword(hash);
    	facade.create(entity);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
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
    @Produces({"application/xml", "application/json"})
    public TcUser find(@PathParam("id") Integer id) {
    	return facade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<TcUser> findAll() {
        return facade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
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
