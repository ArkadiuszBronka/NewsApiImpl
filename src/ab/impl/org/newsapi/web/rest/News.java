package ab.impl.org.newsapi.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ab.impl.org.newsapi.data.TopHeadlines;

@Path("news")
public class News {

	@GET
	@Path("testRest")
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloRestClient() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("https://newsapi.org");
		webTarget = webTarget.path("/v2/top-headlines");
		webTarget = webTarget.queryParam("apiKey", "2c2274ddbc5340afb9dbe54ad525aabf");
		webTarget = webTarget.queryParam("country", "pl");
		webTarget = webTarget.queryParam("category", "technology");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		TopHeadlines topHeadlines = invocationBuilder.get(TopHeadlines.class);

		return Response.status(200).entity(topHeadlines).build();
	}
}
