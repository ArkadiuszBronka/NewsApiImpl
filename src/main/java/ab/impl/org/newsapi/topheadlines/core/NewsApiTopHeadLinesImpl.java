package ab.impl.org.newsapi.topheadlines.core;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import ab.impl.org.newsapi.core.Logic;
import ab.impl.org.newsapi.core.data.Result;
import ab.impl.org.newsapi.topheadlines.data.TopHeadlines;

public class NewsApiTopHeadLinesImpl implements Logic {
	private String lang;
	private String category;
	private String pageSize;
	private String page;

	public NewsApiTopHeadLinesImpl(String lang, String category, String pageSize, String page) {
		this.lang = lang;
		this.category = category;
		this.pageSize = pageSize;
		this.page = page;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Result readData() {
		Result result = readDataFromSource();
		return result;
	}

	private TopHeadlines readDataFromSource() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(Configuration.URL);
		webTarget = webTarget.path(Configuration.PATH);

		if (lang != null) {
			webTarget = webTarget.queryParam(Configuration.LANG, lang);
		}

		if (category != null) {
			webTarget = webTarget.queryParam(Configuration.CATEGORY, category);
		}

		if (pageSize != null) {
			webTarget = webTarget.queryParam(Configuration.PAGE_SIZE, pageSize);
		}

		if (page != null) {
			webTarget = webTarget.queryParam(Configuration.PAGE, page);
		}

		System.out.println(webTarget.toString());
		// System.out.println(webTarget.getUri().toString());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(Configuration.API_KEY_NAME, Configuration.API_KEY_VALUE);

		TopHeadlines topHeadlines = null;
		try {
			topHeadlines = invocationBuilder.get(TopHeadlines.class);
		} catch (NotFoundException | NotAuthorizedException | BadRequestException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			topHeadlines = new TopHeadlines();
			
			switch (e.getResponse().getStatus()) {
			case 400:
				topHeadlines.setCode("400");
				topHeadlines.setMessage("Bad Request. The request was unacceptable, often due to a missing or misconfigured parameter.");
				break;
			case 401:
				topHeadlines.setCode("401");
				topHeadlines.setMessage("Unauthorized. Your API key was missing from the request, or wasn't correct.");
				break;
			case 404:
				topHeadlines.setCode("404");
				topHeadlines.setMessage("Page not found.");
				break;
			default:
				topHeadlines.setCode("500");
				topHeadlines.setMessage("Server Error. Something went wrong on our side.");
				break;
			}
		}
		topHeadlines = extendResponseData(topHeadlines);

		//System.out.println(topHeadlines);
		
		return topHeadlines;
	}

	private TopHeadlines extendResponseData(TopHeadlines topHeadlines) {
		topHeadlines.setLang(lang);
		topHeadlines.setCategory(category);

		return topHeadlines;
	}
}
