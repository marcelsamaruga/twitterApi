/**
 * @author Marcel
 *
 */
package br.com.mycompany.twitterApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.RestAssured;

import br.com.mycompany.twitterApi.config.BaseTests;

@RunWith(MockitoJUnitRunner.class)
public class TwitterLogResourceTest extends BaseTests {

	static final Logger logger = Logger.getLogger(TwitterLogResourceTest.class);
	
	// *** *** *** *** *** *** *** *** *** ***
	
	@BeforeClass
    public static void beforeClass() throws Exception {
    	RestAssured.baseURI = BASE_REST_URL;
    }
	
	// *** *** *** *** *** *** *** *** *** ***
	
	@Test
	public void test_filter_twitter() {
		
		final String SEARCH_URI = "/twitterApi/search";
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("username", "marcelsamaruga");
		param.put("value", "Twitter4J");
		
		// retrieve the log from the rest webservice
		String postResult = RestAssured.given()
									   .contentType("application/json")
									   .parameters(param)
									   .post( SEARCH_URI )
									   .thenReturn()
									   .body()
									   .jsonPath()
									   .get("log");
		
		System.out.println(postResult);
		
	}
	
}
