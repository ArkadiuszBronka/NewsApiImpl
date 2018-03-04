package ab.impl.org.newsapi.data;

import java.util.List;

public class TopHeadlines implements Result {

	private String status;
	private String code;
	private String message;

	private int totalResults;
	private List<Article> articles;

	private String lang;
	private String category;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
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

	@Override
	public String getCountry() {
		return lang;
	}

	@Override
	public String getErrorCode() {
		return getCode();
	}

	@Override
	public String getErrorMesage() {
		return getMessage();
	}

	@Override
	public int getAvailableArticlesToFetch() {
		return totalResults;
	}
}
