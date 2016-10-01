package br.com.mycompany.twitterApi;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;

import br.com.mycompany.twitterApi.config.Application;
import br.com.mycompany.twitterApi.service.TwitterLogService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@IntegrationTest("server.port:0")  
public class SpringRestApplicationTests {

//	@MockBean
    private TwitterLogService service;
	
	@Test
	public void contextLoads() {
	}
	
//	@Test
//    public void testSayHelloWorld() throws Exception{
//
//         this.mockMvc.perform(get("/")
//                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType("application/json"));
//    }
//
//    @Test
//    public void contextLoads() {
//    }
	
	
//	@BeforeClass
//	public static void startBootApp(){
//	appContext = SpringApplication.run(Application.class, "");
//	}
//
//	@AfterClass
//	public static void shutdownBootApp(){
//	appContext.close();
//	}

}
