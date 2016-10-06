/**
 * 
 */
package br.com.mycompany.twitterApi.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Marcel
 *
 */
public abstract class BaseTests {

	protected static String BASE_REST_URL;
	
	static {
		try {

			Properties prop = new Properties();
			InputStream input = new FileInputStream("src/test/resources/application.properties");

			// load a properties file
			prop.load(input);
			input.close();
			
			BASE_REST_URL = prop.getProperty("base_url");
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}