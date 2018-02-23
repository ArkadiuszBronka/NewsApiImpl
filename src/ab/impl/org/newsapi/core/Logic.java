package ab.impl.org.newsapi.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import ab.impl.org.newsapi.data.Article;
import ab.impl.org.newsapi.data.TopHeadlines;

public class Logic {

	public TopHeadlines readData() {
		return readDataFromSource();
	}

	private TopHeadlines readDataFromSource()
	{
		// https://newsapi.org/v2/top-headlines?country=pl&apiKey=2c2274ddbc5340afb9dbe54ad525aabf&category=technology

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("https://newsapi.org");
		WebTarget employeeWebTarget = webTarget.path("/v2/top-headlines");
		employeeWebTarget = employeeWebTarget.queryParam("apiKey", "2c2274ddbc5340afb9dbe54ad525aabf");
		employeeWebTarget = employeeWebTarget.queryParam("country", "pl");
		employeeWebTarget = employeeWebTarget.queryParam("category", "technology");

		Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_JSON);

		TopHeadlines topHeadlines = invocationBuilder.get(TopHeadlines.class);
	
		return topHeadlines;
	}

	public static void main(String[] args) {
		Logic logic = new Logic();
		TopHeadlines topHeadlines = logic.readData();
		
		System.out.println("Status:" + topHeadlines.getStatus() + ", errorCode:" + topHeadlines.getCode() + ", message:" + topHeadlines.getMessage() + " count:" + topHeadlines.getTotalResults());
		
		for (Article article : topHeadlines.getArticles()) {
			System.out.println(article);
		}
	}
}
