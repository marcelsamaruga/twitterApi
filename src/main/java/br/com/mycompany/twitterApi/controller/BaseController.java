/**
 * @author marcel.costa
 * @name: BaseController.java
 * @description: Abstract class extended by the controllers in order to keep the common functions for the controllers 
 * */
package br.com.mycompany.twitterApi.controller;

import br.com.mycompany.twitterApi.service.BaseService;

public abstract class BaseController<T, S extends BaseService<T>> {
	
	public abstract S getService();
	public abstract T getEntity();
	
	public abstract void setService(S s);
	public abstract void setEntity(T t);
	
}
