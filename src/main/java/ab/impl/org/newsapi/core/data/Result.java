package ab.impl.org.newsapi.core.data;

import java.util.List;

public interface Result {
	public List getItems();

	public String getCountry();

	public String getCategory();

	public String getErrorCode();

	public String getErrorMesage();

	public int getAvailableArticlesToFetch();
}
