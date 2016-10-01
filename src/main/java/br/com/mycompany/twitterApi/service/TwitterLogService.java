/**
 * @author marcel.costa
 * @name: CustomerService.java * 
 * @description: Webservice layer used to access the controllers by REST 
 * 
 * Service: marks the class as a Spring service prototype
 * Transactional: forces all the class methods as transactional
 * */
package br.com.mycompany.twitterApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mycompany.twitterApi.entity.TwitterLog;
import br.com.mycompany.twitterApi.repository.TwitterLogRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TwitterLogService extends BaseService<TwitterLog> {

	@Autowired
	TwitterLogRepository repository;

	@Override
	public TwitterLogRepository getRepository() {
		return repository;
	}
}
