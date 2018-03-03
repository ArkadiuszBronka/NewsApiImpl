package ab.impl.org.newsapi.data;

import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Article {
	private Source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private Date publishedAt;

	@JsonbProperty("sourceName")
	public String getSourceName() {
		if (source != null) {
			return source.getName();
		}
		return null;
	}

	@JsonbTransient
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonbProperty("articleUrl")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonbProperty("imageUrl")
	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	
	@JsonbProperty("date")
	@JsonbDateFormat("yyyy-MM-dd")
	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	@Override
	public String toString() {
		return "source: " + source.getId() + " name: " + source.getName() + " author: " + this.getAuthor()
				+ " description: " + this.getDescription() + " date: " + this.getPublishedAt() + " title: "
				+ this.getTitle() + " url: " + this.getUrl() + " image: " + this.getUrlToImage();
	}
}