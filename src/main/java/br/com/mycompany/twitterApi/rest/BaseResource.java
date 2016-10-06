package br.com.mycompany.twitterApi.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author marcel.costa
 * Resource super class
 * */
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseResource {

	/**
	 * @author marcel.costa
	 * This function returns a OK response status and creates an JSON element according to the entity attributes
	 * */
	protected Response responseSuccess( final Object entity ) {
		return responseStatus( Status.OK, entity ).build();
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a error response and creates an error message in a JSONObject
	 * */
	protected Response responseError( final String message ) {
		
		Map<String, String> errorJSONObject = new HashMap<String, String>();

		// create a JSONObject element using the code/message of the error
		errorJSONObject.put("code",    String.valueOf(Status.INTERNAL_SERVER_ERROR.getStatusCode()) );
		errorJSONObject.put("message", message );

		return responseStatus( Status.INTERNAL_SERVER_ERROR, errorJSONObject ).build();
	}

	
	/**
	 * @author marcel.costa
	 * This function returns a response statement according to the status object sent by parameter
	 * */
	protected ResponseBuilder responseStatus( final Status status, final Object entity ) {
		return responseStatus( status ).entity( entity ).tag("twitterAPI");
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a response statement according to the status object sent by parameter
	 * */
	protected ResponseBuilder responseStatus( final Status status ) {
		return Response.status( status ).tag( status.getReasonPhrase() );
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a JSON object sent by parameter
	 * */
	protected Response responseSuccessASJson(final Object entity) {
		try {			
			// create GSon converter
			Gson gson = new GsonBuilder().create();
	    	return responseSuccess( gson.toJson(entity) );
	    	
		} catch (Exception e) {
			return responseError( e.getMessage() );
		}		
	}
	
	
	/**
	 * @author marcel.costa
	 * This function returns a JSON object sent by parameter
	 * */
	protected Response responseASJson(Status status,  final Object entity) {
		try {			
			// create GSon converter
			Gson gson = new GsonBuilder().create();
	    	return responseStatus( status, gson.toJson(entity) ).build();
	    	
		} catch (Exception e) {
			return responseError( e.getMessage() );
		}		
	}
	
}