/**
 * @author marcel.costa
 * @name: BaseService.java * 
 * @description: Abstract class develop to keep the commons methods of the JPA Spring Data layer 
 * */
package br.com.mycompany.twitterApi.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcel
 *
 * @param <T>
 */
public abstract class BaseService<T> {

	public abstract JpaRepository<T, Long> getRepository();
	
	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#findById(java.lang.Long)
	 */
	public T findById(Long id) {
		return getRepository().findOne(id);
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#findAll()
	 */
	public List<T> findAll() {
		return getRepository().findAll();
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#delete(java.lang.Long)
	 */
	public void delete(Long id) {
		getRepository().delete(id);
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#save(java.lang.Object)
	 */
	public T save(T entity) {
		return getRepository().save( entity );
	}
	
	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#findAll(Sort)
	 */
	public List<T> findAll(Sort sort) {
		return getRepository().findAll();
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#findAll(Iterable<java.lang.Object>)
	 */
	public List<T> findAll(Iterable<Long> ids) {
		return getRepository().findAll(ids);
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#flush
	 */
	public void flush() {
		getRepository().flush();
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#saveAndFlush(java.lang.Object)
	 */
	public T saveAndFlush(T entity) {
		return getRepository().saveAndFlush(entity);
	}
	
	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#saveAndFlush(java.lang.Object)
	 */
	public List<T> save(Iterable<T> entity) {
		return getRepository().save(entity);
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#deleteInBatch(Iterable<java.lang.Object>)
	 */
	public void deleteInBatch(Iterable<T> entities) {
		getRepository().deleteInBatch(entities);
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#deleteAllInBatch
	 */
	public void deleteAllInBatch() {
		getRepository().deleteAllInBatch();
	}

	/**
	 * @see br.com.contabilizei.service.interfaces.BaseService#getOne(java.lang.Long)
	 */
	public T getOne(Long id) {
		return getRepository().getOne(id);
	}

}
