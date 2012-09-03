package web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class TCApplication extends Application {

	private static final Set<Class<?>> classes = new HashSet<Class<?>>();

	@Override
	public Set<Class<?>> getClasses() {
		if (classes.isEmpty()) {
			classes.add(TcConsumptionFacadeREST.class);
			classes.add(TcTruckFacadeREST.class);
			classes.add(TcUserFacadeREST.class);
		}
		return super.getClasses();
	}
}
