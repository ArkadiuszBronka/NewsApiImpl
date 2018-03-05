package ab.impl.org.newsapi.topheadlines.data;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class TopHeadlines {
	private String status;
	private int code;
	private String message;
	private int totalResults;
	private List<Article> articles;
	private String lang;
	private String category;

	@JsonbTransient
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonbTransient
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@JsonbTransient
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonbTransient
	public int getTotalResults() {
		return totalResults;
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

	@JsonbProperty("country")
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

	@Override
	public String toString() {
		return "ErrorCode:" + code + ", ErrorMessage:" + message;
	}
}
