/**
 * @author marcel.costa
 * @name: CustomerController.java
 * @description: Controller layer to access the services 
 * */
package br.com.mycompany.twitterApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mycompany.twitterApi.entity.TwitterLog;
import br.com.mycompany.twitterApi.service.TwitterLogService;

@Controller
@RequestMapping("/twitterLog")
public class TwitterLogController extends BaseController<TwitterLog, TwitterLogService> {
	
	@Autowired
	TwitterLogService service;
	
	TwitterLog entity;

	@Override
	public TwitterLogService getService() {
		return service;
	}
	
	@Override
	public void setService(TwitterLogService twitterLogService) {
		this.service = twitterLogService;
	}

	@Override
	public TwitterLog getEntity() {
		return entity;
	}
	
	@Override
	public void setEntity(TwitterLog entity) {
		this.entity = entity;
	}
}