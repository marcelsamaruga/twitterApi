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

import br.com.mycompany.twitterApi.entity.TwitterUser;
import br.com.mycompany.twitterApi.repository.TwitterUserRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TwitterUserService extends BaseService<TwitterUser> {

	@Autowired
	TwitterUserRepository repository;

	@Override
	public TwitterUserRepository getRepository() {
		return repository;
	}

	public TwitterUser findByLogin(String login) {
		return getRepository().findByLogin(login);
	}
}
