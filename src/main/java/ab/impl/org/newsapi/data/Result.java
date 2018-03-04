package ab.impl.org.newsapi.data;

import java.util.List;

public interface Result {
	public List<Article> getArticles();

	public String getCountry();

	public String getCategory();

	public String getErrorCode();

	public String getErrorMesage();

	public int getAvailableArticlesToFetch();
}
