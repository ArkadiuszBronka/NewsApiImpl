package ab.impl.org.newsapi.web.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import ab.impl.org.newsapi.topheadlines.data.TopHeadlines;
import ab.impl.org.newsapi.web.rest.News;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Application;

public class NewsTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(News.class);
    }

    @Test
    public void ordersPathParamTest() {
    	TopHeadlines response = target("news/pl/technology").request().get(TopHeadlines.class);
    	
    	System.out.println(response.getCode() + " | " + response.getMessage() + " | " + response.getTotalResults());
    	
    	//Assert.assertEquals(200, response.getCode());
    	
    	
		Jsonb jsonb = JsonbBuilder.create();
		String json = jsonb.toJson(response);
		
		System.out.println(json);
		
        Assert.assertNotNull(response);
        //Assert.assertTrue("orderId: 453".equals(response));

    }
/*
    @Test
    public void ordersFixedPathTest() {
        String response = target("orders/summary").request().get(String.class);
        Assert.assertTrue("orders summary".equals(response));
    }
*/
}