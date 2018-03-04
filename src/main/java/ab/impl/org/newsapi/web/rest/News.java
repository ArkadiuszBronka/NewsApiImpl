package ab.impl.org.newsapi.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ab.impl.org.newsapi.core.Logic;
import ab.impl.org.newsapi.data.Article;
import ab.impl.org.newsapi.data.Result;


@Path("news")
public class News {

	@GET
	@Path("{lang}/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloRestClient(@PathParam("lang") String lang, @PathParam("category") String category,
			@QueryParam("pageSize") String pageSize, @QueryParam("page") String page) {

		Logic logic = new Logic();
		logic.setLang(lang);
		logic.setCategory(category);
		logic.setPageSize(pageSize);
		logic.setPage(page);

		Result result = logic.readData();

		return Response.status(200).entity(result).build();
	}

	public static void main(String[] args) {
		Logic logic = new Logic();
		logic.setLang("pl");
		logic.setCategory("technology");

		Result result = logic.readData();

		// System.out.println("Status:" + result.getStatus() + ", errorCode:" +
		// result.getCode() + ", message:" + result.getMessage() + " count:" +
		// result.getTotalResults());
		System.out.println("Language:" + result.getCountry() + ", category:" + result.getCategory());
		for (Article article : result.getArticles()) {
			System.out.println(article);
		}
	}
}
