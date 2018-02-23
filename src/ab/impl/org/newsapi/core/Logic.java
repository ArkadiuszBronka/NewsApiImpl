package ab.impl.org.newsapi.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import ab.impl.org.newsapi.data.Article;
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
	
	public TopHeadlines readData() {
		return readDataFromSource();
	}

	private TopHeadlines readDataFromSource()
	{
		// https://newsapi.org/v2/top-headlines?country=pl&apiKey=2c2274ddbc5340afb9dbe54ad525aabf&category=technology

		System.out.println("lang=" + lang + " category=" + category + " pageSize=" + pageSize + " page=" + page);
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("https://newsapi.org");
		webTarget = webTarget.path("/v2/top-headlines");
		webTarget = webTarget.queryParam("apiKey", "2c2274ddbc5340afb9dbe54ad525aabf");
		
		if(lang != null) {
			webTarget = webTarget.queryParam("country", lang);
		}
		
		if(category != null) {
			webTarget = webTarget.queryParam("category", category);
		}
		
		if(pageSize != null) {
			webTarget = webTarget.queryParam("pageSize", pageSize);
		}
		
		if(page !=null) {
			webTarget = webTarget.queryParam("page", page);
		}
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

		TopHeadlines topHeadlines = invocationBuilder.get(TopHeadlines.class);
	
		return topHeadlines;
	}

	public static void main(String[] args) {
		Logic logic = new Logic();
		logic.setLang("pl");
		logic.setCategory("technology");

		TopHeadlines topHeadlines = logic.readData();
		
		System.out.println("Status:" + topHeadlines.getStatus() + ", errorCode:" + topHeadlines.getCode() + ", message:" + topHeadlines.getMessage() + " count:" + topHeadlines.getTotalResults());
		
		for (Article article : topHeadlines.getArticles()) {
			System.out.println(article);
		}
	}
}
