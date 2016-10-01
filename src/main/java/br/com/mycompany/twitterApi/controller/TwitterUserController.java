/**
 * @author marcel.costa
 * @name: CustomerController.java
 * @description: Controller layer to access the services 
 * */
package br.com.mycompany.twitterApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mycompany.twitterApi.entity.TwitterUser;
import br.com.mycompany.twitterApi.service.TwitterUserService;

@Controller
@RequestMapping("/twitterUser")
public class TwitterUserController extends BaseController<TwitterUser, TwitterUserService> {
	
	@Autowired
	TwitterUserService service;
	
	TwitterUser entity;

	@Override
	public TwitterUserService getService() {
		return service;
	}
	
	@Override
	public void setService(TwitterUserService twitterLogService) {
		this.service = twitterLogService;
	}

	@Override
	public TwitterUser getEntity() {
		return entity;
	}
	
	@Override
	public void setEntity(TwitterUser entity) {
		this.entity = entity;
	}
	
	/** retrieve the TwitterUser object based on its name
	 * */
	public TwitterUser findByLogin(String login) {
		return getService().findByLogin(login);
	}
}