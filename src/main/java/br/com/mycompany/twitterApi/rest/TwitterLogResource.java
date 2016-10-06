/**
 * @author marcel.costa
 * @name: CustomerRest.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * */
package br.com.mycompany.twitterApi.rest;

import static br.com.mycompany.twitterApi.util.ConstantsUtil.REST_DOMAIN;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mycompany.twitterApi.entity.TweetPost;
import br.com.mycompany.twitterApi.entity.TwitterLog;
import br.com.mycompany.twitterApi.entity.TwitterUser;
import br.com.mycompany.twitterApi.service.TwitterLogService;
import br.com.mycompany.twitterApi.service.TwitterUserService;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@RestController
@RequestMapping( REST_DOMAIN + "/twitterApi")
public class TwitterLogResource extends BaseResource {
	
	final static Logger logger = Logger.getLogger(TwitterLogResource.class);
	
	/*************************/
	@Autowired
	TwitterLogService twitterLogService;
	
	@Autowired
	TwitterUserService twitterUserService;
	/*************************/
	
	/**
	 * @author marcel.costa
	 * @param queryValue: value to search on the twitter
	 * @param username: twitter account
	 * @return json
	 * description: function is responsible to query on the twitter and save the information 
	 * @throws TwitterException 
	 * */	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody Response search(@RequestParam(value = "value")    final String filter,
										 @RequestParam(value = "username") final String username ) throws TwitterException 
	{
		if ( StringUtils.isEmpty(username) || StringUtils.isEmpty(filter) ) {
			return super.responseError("The username/filter are not avaiable.");
		}
		
		// gets a twitter instance 
		Twitter twitter = new TwitterFactory().getInstance();

		// returned list
		List<TwitterLog> listTwitterLog = new ArrayList<TwitterLog>();
		 
		try {
			// request user validation
			// gets the username from the Twitter account
			TwitterUser twitterRequestUser = this.getTwitterUser(twitter.showUser(username));
			 
			// *** *** ***

			// invoke twitter function to filter all the elements in the search method
			Query query = new Query(filter);
			QueryResult result = twitter.search(query);
			 
			byte rateLimit = 0;
			
			for (Status tweet : result.getTweets()) {						
				// check if is a retweet						
				if ( !tweet.isRetweet() ) {
					TwitterLog twitterLog = new TwitterLog();
					
					twitterLog.setTwitterUser( 
							this.getTwitterUser( twitter.showUser(tweet.getUser().getScreenName()) ) 
					);
					
					twitterLog.setTwitterUserRequest( twitterRequestUser );
					
					twitterLog.setLog( tweet.getText() );
					twitterLog.setDate( tweet.getCreatedAt() );
					twitterLog.setCountRetweet( Long.valueOf(tweet.getRetweetCount()) );
					twitterLog.setCountFavorite( Long.valueOf(tweet.getFavoriteCount()) );
					
					listTwitterLog.add(twitterLog);							
					
					if (rateLimit++ >= 10) {
						break;
					}
				}
			}
			
			twitterLogService.save(listTwitterLog);
	
	            
        } catch (TwitterException te) {
            logger.error(te.getMessage());
            return super.responseError(te.getMessage());
        }
	 
		Response response = super.responseSuccessASJson( listTwitterLog );
		return response;
	}
	
	
	/**
	 * @param showUser
	 * @return
	 */
	private TwitterUser getTwitterUser(final User user) {		
		TwitterUser twitterUser = twitterUserService.findByLogin( user.getScreenName() );
		 
		 if (twitterUser == null) {
			 twitterUser = new TwitterUser();
			 twitterUser.setCreated(user.getCreatedAt());
			 twitterUser.setLogin(user.getScreenName());
			 twitterUser.setName(user.getName());
			 twitterUser.setLocation(user.getLocation());
			 twitterUser.setProfileImageURL(user.getProfileImageURL());
			 twitterUser.setDescription(user.getDescription());
			 twitterUser.setURL(user.getURL());
			 //
			 twitterUserService.saveAndFlush(twitterUser);
		 }
		 
		 return twitterUser;
	}
	
	
	/**
	 * @author marcel.costa
	 * @param username: username to validate twitter account
	 * @param jsonMessage: json string containing  the message to consume
	 * @return json
	 * description: update Twitter status acoount
	 * @throws  
	 * */
	@RequestMapping(value = "/tweet", method = RequestMethod.POST)	
	public @ResponseBody Response createTweet(
			@RequestParam(value = "username") final String username, 
			@RequestParam(value = "message") final String jsonMessage, 
			@RequestBody final String allContent)  
	{		

		TweetPost post = null;
		
		// parse the JSON from the requestParam from a Java Object using Gson
		try {
			Gson gson = new Gson();
			post = gson.fromJson(jsonMessage, TweetPost.class);
			
		} catch(Exception parseException) {
			logger.error( parseException.getMessage() );
			return super.responseError( parseException.getMessage() );
		}
		
		Twitter twitter = new TwitterFactory().getInstance();

		try {
			// validate the username
			User user = twitter.showUser(username);
			
			if (user != null) {
				twitter.updateStatus( post.getMessage() );
			}
			
		} catch (TwitterException e) {
			return super.responseError(e.getErrorMessage());
		}
	    
		return super.responseSuccess( post.getMessage() );
	}
	
}
