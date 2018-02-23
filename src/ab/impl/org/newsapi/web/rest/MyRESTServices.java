package ab.impl.org.newsapi.web.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("restservices")
public class MyRESTServices extends ResourceConfig {
	public MyRESTServices() {
		packages("ab.impl.org.newsapi.web.rest");
	}
}