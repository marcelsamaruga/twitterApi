/**
 * @author marcel.costa
 * @name: CustomerRepository.java * 
 * @description: Methods to access the database using JPA Spring Data 
 * */
package br.com.mycompany.twitterApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mycompany.twitterApi.entity.TwitterLog;

/**
 * @author Marcel
 *
 */
public interface TwitterLogRepository extends JpaRepository<TwitterLog, Long> {

}
