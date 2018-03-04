package ab.impl.org.newsapi.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import ab.impl.org.newsapi.data.Result;
import ab.impl.org.newsapi.data.TopHeadlines;

public class Logic {

	private String lang;
	private String category;
	private String pageSize;
	private String page;
	
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
		TopHeadlines topHeadlines = readDataFromSource();
		Result result = new Result();
		result.setArticles(topHeadlines.getArticles());
		result = extendResponseData(result);
		return result;
	}

	private TopHeadlines readDataFromSource()
	{
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(Configuration.URL);
		webTarget = webTarget.path(Configuration.PATH);
		
		if(lang != null) {
			webTarget = webTarget.queryParam(Configuration.LANG, lang);
		}
		
		if(category != null) {
			webTarget = webTarget.queryParam(Configuration.CATEGORY, category);
		}
		
		
		if(pageSize != null) {
			webTarget = webTarget.queryParam(Configuration.PAGE_SIZE, pageSize);
		}
		
		if(page !=null) {
			webTarget = webTarget.queryParam(Configuration.PAGE, page);
		}
		
		System.out.println(webTarget.toString());
		//System.out.println(webTarget.getUri().toString());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header(Configuration.API_KEY_NAME, Configuration.API_KEY_VALUE);
	
		TopHeadlines topHeadlines = invocationBuilder.get(TopHeadlines.class);
		
		return topHeadlines;
	}

	private Result extendResponseData(Result result) {
		result.setCounty(lang);
		result.setCategory(category);
		
		return result;
	}
}
