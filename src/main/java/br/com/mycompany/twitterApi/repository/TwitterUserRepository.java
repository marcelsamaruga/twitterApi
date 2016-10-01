/**
 * @author marcel.costa
 * @name: CustomerRepository.java * 
 * @description: Methods to access the database using JPA Spring Data 
 * */
package br.com.mycompany.twitterApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mycompany.twitterApi.entity.TwitterUser;

/**
 * @author Marcel
 *
 */
public interface TwitterUserRepository extends JpaRepository<TwitterUser, Long> {

	TwitterUser findByLogin(String login);

}
