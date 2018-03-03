package ab.impl.org.newsapi.data;

import java.util.List;

public class Result {
	
	private List<Article> articles;
	private String country;
	private String category;
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getCountry() {
		return country;
	}

	public void setCounty(String country) {
		this.country = country;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
