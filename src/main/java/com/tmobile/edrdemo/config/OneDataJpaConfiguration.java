package com.tmobile.edrdemo.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "onedataEntityManagerFactory", transactionManagerRef = "onedataTransactionManager", basePackages = {
		"com.tmobile.prts.ran.dao.onedata" })
public class OneDataJpaConfiguration {

	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "onedataJPADS")
	public DataSource getDataSource() {
		/**
		DataSource dataSource = DataSourceBuilder.create()
				.driverClassName(env.getProperty("spring.oracle.datasource.driver-class-name"))
				.url(env.getProperty("spring.onedata.datasource.jdbc-url"))
				.username("\"3t0_nppi_ats\"") //env.getProperty("spring.onedata.datasource.username")
				.password("\"3T0_nPPi_ats23#\"").build(); //env.getProperty("spring.onedata.datasource.password")
		*/

		DataSource dataSource = DataSourceBuilder.create().driverClassName("oracle.jdbc.driver.OracleDriver")
				.url("jdbc:oracle:thin:@gbl-poned1.unix.gsm1900.org:7663:ponedp2").username("\"3t0_nppi_ats\"")
				.password("\"3T0_nPPi_ats23#\"").build();
			
		return dataSource;
	}
	
	@Primary
	@Bean(name = "onedataEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("onedataJPADS") DataSource dataSource)	{
		Map<String,Object> properties = new HashMap<String,Object>();
		//
		properties.put("spring.orcl.jpa.properties.hibernate.dialect", env.getProperty("spring.orcl.jpa.properties.hibernate.dialect"));
		System.out.println("classpath=" + env.getProperty("server.ssl.key-store"));
		/**
		properties.put("spring.datasource.hikari.minimumIdle", env.getProperty("spring.orcl.datasource.hikari.minimumIdle"));
		properties.put("spring.datasource.hikari.maximumPoolSize", env.getProperty("spring.orcl.datasource.hikari.maximumPoolSize"));
		properties.put("spring.datasource.hikari.idleTimeout", env.getProperty("spring.orcl.datasource.hikari.idleTimeout"));
		properties.put("spring.datasource.hikari.maxLifetime", env.getProperty("spring.orcl.datasource.hikari.maxLifetime"));
		properties.put("spring.datasource.hikari.connectionTimeout", env.getProperty("spring.orcl.datasource.hikari.connectionTimeout"));
		properties.put("spring.datasource.hikari.poolName", env.getProperty("spring.orcl.datasource.hikari.poolName"));
		*/
		return builder.dataSource(dataSource).properties(properties).packages("com.tmobile.prts.ran.domain.onedata").persistenceUnit("onedataPU").build();
	}
	
	@Primary
	@Bean(name = "onedataTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("onedataEntityManagerFactory") EntityManagerFactory factory)	{
		return new JpaTransactionManager(factory);
	}
	
}
