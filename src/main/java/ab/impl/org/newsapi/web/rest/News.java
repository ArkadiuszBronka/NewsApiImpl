package ab.impl.org.newsapi.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ab.impl.org.newsapi.core.Logic;
import ab.impl.org.newsapi.core.data.Result;
import ab.impl.org.newsapi.topheadlines.core.NewsApiTopHeadLinesImpl;

@Path("news")
public class News {

	@GET
	@Path("{lang}/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloRestClient(@PathParam("lang") String lang, @PathParam("category") String category,
			@QueryParam("pageSize") String pageSize, @QueryParam("page") String page) {

		Logic logic = new NewsApiTopHeadLinesImpl(lang, category, pageSize, page);
		Result result = logic.readData();

		return Response.status(200).entity(result).build();
	}

	public static void main(String[] args) {
		Logic logic = new NewsApiTopHeadLinesImpl("pl", "technology", null, null);

		Result result = logic.readData();
		System.out.println(result);

		if (result.getItems() != null) {
			for (Object article : result.getItems()) {
				System.out.println(article);
			}
		}
	}
}
