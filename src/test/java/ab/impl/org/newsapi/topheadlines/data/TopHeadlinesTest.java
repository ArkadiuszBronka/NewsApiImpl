package ab.impl.org.newsapi.topheadlines.data;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TopHeadlinesTest {

	String inputJson = "{\"status\":\"ok\",\"totalResults\":20,\"articles\":[{\"source\":{\"id\":null,\"name\":\"Complex.com\"},"
			+ "\"author\":\"Gavin Evans\","
			+ "\"title\":\"Lawsuit Says\","
			+ "\"description\":\"A new lawsuit says.\","
			+ "\"url\":\"http://www.complex.com/sports/2018/03/lawsuit-says-chris-berman-sent-jemele-hill-a-racially-charged-voicemail-in-2016\","
			+ "\"urlToImage\":\"https://images.complex.com/complex/images/c_fill,g_center,w_1200/fl_lossy,pg_1,q_auto/p944wjcqccgwx6u9hkef/chris-berman\","
			+ "\"publishedAt\":\"2018-03-06T00:56:15Z\"},{\"source\":{\"id\":\"the-washington-post\",\"name\":\"The Washington Post\"},"
			+ "\"author\":\"https://www.facebook.com/paul.kane.3367\","
			+ "\"title\":\"Mississippi's Thad Cochran to resign from Senate after four-decade congressional career\""
			+ ",\"description\":\"The Republican, 80, who has appeared frail in recent months, said his health has become “an ongoing challenge.”\","
			+ "\"url\":\"https://www.washingtonpost.com/powerpost/mississippis-sen-thad-cochran-to-resign-from-the-senate-after-four-decade-congressional-career/2018/03/05/be8477d4-20c0-11e8-94da-ebf9d112159c_story.html\","
			+ "\"urlToImage\":\"https://www.washingtonpost.com/rf/image_1484w/2010-2019/WashingtonPost/2018/03/05/National-Politics/Images/916030032.jpg\",\"publishedAt\":\"2018-03-06T00:51:48Z\"}]}";

	//private Jsonb responseJson = null;
	private TopHeadlines topHeadlines = null;

	@Before
	public void prepareJson() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		topHeadlines = mapper.readValue(inputJson, TopHeadlines.class);
	}

	@Test
	public void getStatusTest() {
		Assert.assertEquals("ok", topHeadlines.getStatus());
	}
	
	@Test
	public void getTotalResultTest() {
		Assert.assertEquals(20, topHeadlines.getTotalResults());
	}
	@Test
	public void articlesCountTest() {
		Assert.assertEquals(2, topHeadlines.getArticles().size());
	}
	@Test
	public void articlesAuthorTest() {
		Assert.assertEquals("Gavin Evans", topHeadlines.getArticles().get(0).getAuthor());
	}
}
