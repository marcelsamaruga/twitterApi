/**
 * @author marcel.costa
 * @name: DataConfig.java
 * @description: configures the database access
 * 
 * Configuration: initialized on the boot spring application
 * EnableTransactionManagement: marks the repositories as transactional
 * EnableJpaRepositories: enable all the classes management by the JPA Spring Data
 * */
package br.com.mycompany.twitterApi.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.mycompany.twitterApi.repository")
//@PropertySource(value="classpath:application.properties")
public class DataConfig {

	@Value(value = "${jdbc.url}")
	private String url;
	
	@Value(value = "${jdbc.password}")
	private String password;
	
	@Value(value = "${jdbc.username}")
	private String username;
	
	@Value(value = "${jdbc.driver}")
	private String driver;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driver);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		//
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		//
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(adapter);
		factoryBean.setPackagesToScan("br.com.mycompany.twitterApi.entity");
		factoryBean.setDataSource(dataSource());
		//
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		manager.setJpaDialect(new HibernateJpaDialect());
		//
		return manager;
		
	}
}
