package ab.impl.org.newsapi.topheadlines.core;

import org.junit.Assert;
import org.junit.Test;

import ab.impl.org.newsapi.core.Logic;
import ab.impl.org.newsapi.topheadlines.data.TopHeadlines;

public class NewsApiTopHeadLinesImplTest {
	@Test
	public void checkResponseCode200Test() {
		Logic logic = new NewsApiTopHeadLinesImpl("pl", null, null, null);
		TopHeadlines result = logic.readData();
		Assert.assertTrue("incorrect response code received.", result.getCode() == 200);
	}

	@Test
	public void checkResponseCode400Test() {
		Logic logic = new NewsApiTopHeadLinesImpl("pl", null, "1000", null);
		TopHeadlines result = logic.readData();
		Assert.assertTrue("incorrect response code received.", result.getCode() == 400);
	}

	@Test
	public void checkResponseCode400Test_1() {
		Logic logic = new NewsApiTopHeadLinesImpl(null, null, "20", "300");
		TopHeadlines result = logic.readData();
		Assert.assertTrue("incorrect response code received.", result.getCode() == 400);
	}

	@Test
	public void checkResponseCode200Test_1() {
		Logic logic = new NewsApiTopHeadLinesImpl("pl", null, null, "300");
		TopHeadlines result = logic.readData();
		Assert.assertTrue("incorrect response code received.", result.getCode() == 200);
	}

	@Test
	public void checkResponseCode200Test_2() {
		Logic logic = new NewsApiTopHeadLinesImpl(null, "test", "50", "3");
		TopHeadlines result = logic.readData();
		Assert.assertTrue("incorrect response code received.", result.getCode() == 200);
	}

	@Test
	public void checkGetLangTest() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl("pl", "test", "20", "3");
		Assert.assertEquals("pl", logic.getLang());
	}

	@Test
	public void checkGetCategoryTest() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl("pl", "test", "20", "3");
		Assert.assertEquals("test", logic.getCategory());
	}

	@Test
	public void checkGetPageSizeTest() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl("pl", "test", "20", "3");
		Assert.assertEquals("20", logic.getPageSize());
	}

	@Test
	public void checkGetPageTest() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl("pl", "test", "20", "3");
		Assert.assertEquals("3", logic.getPage());
	}

	@Test
	public void checkGetLangTest_1() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl(null, null, null, null);
		logic.setLang("pl");
		Assert.assertEquals("pl", logic.getLang());
	}

	@Test
	public void checkGetCategoryTest_1() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl(null, null, null, null);
		logic.setCategory("test");
		Assert.assertEquals("test", logic.getCategory());
	}

	@Test
	public void checkGetPageSizeTest_1() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl(null, null, null, null);
		logic.setPageSize("20");
		Assert.assertEquals("20", logic.getPageSize());
	}

	@Test
	public void checkGetPageTest_1() {
		NewsApiTopHeadLinesImpl logic = new NewsApiTopHeadLinesImpl(null, null, null, null);
		logic.setPage("3");
		Assert.assertEquals("3", logic.getPage());
	}

	/*
	 * @Test public void fetchDataTest1() { Logic logic = new
	 * NewsApiTopHeadLinesImpl("pl", null, null, null); TopHeadlines result =
	 * logic.readData(); Assert.assertTrue("test2", result.getCode() == 400); //
	 * Jsonb jsonb = JsonbBuilder.create(); // String json = jsonb.toJson(result);
	 * // Assert.assertNotNull(json); }
	 */
}
