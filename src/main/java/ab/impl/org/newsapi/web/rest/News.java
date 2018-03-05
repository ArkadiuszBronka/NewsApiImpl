package ab.impl.org.newsapi.web.rest;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ab.impl.org.newsapi.core.Logic;
import ab.impl.org.newsapi.topheadlines.core.NewsApiTopHeadLinesImpl;
import ab.impl.org.newsapi.topheadlines.data.TopHeadlines;

@Path("news")
public class News {

	@GET
	@Path("{lang}/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloRestClient(@PathParam("lang") String lang, @PathParam("category") String category,
			@QueryParam("pageSize") String pageSize, @QueryParam("page") String page) {

		Logic logic = new NewsApiTopHeadLinesImpl(lang, category, pageSize, page);
		TopHeadlines result = logic.readData();

		return Response.status(result.getCode()).entity(result).build();
	}

	public static void main(String[] args) {
		Logic logic = new NewsApiTopHeadLinesImpl("pl", "technology", null, null);

		TopHeadlines result = logic.readData();

		Jsonb jsonb = JsonbBuilder.create();
		String json = jsonb.toJson(result);

		System.out.println(json);
	}
}
