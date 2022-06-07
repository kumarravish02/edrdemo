package com.tmobile.edrdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
public class SpringJdbcConfiguration {

	@Autowired
	private Environment env;
	/**
	@Bean(name="onedatajdbcDS")
	public DataSource getOneDataDataSource()	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@gbl-poned1.unix.gsm1900.org:7663:ponedp2");
        dataSource.setUsername("\"3t0_nppi_ats\"");
        dataSource.setPassword("\"3T0_nPPi_ats23#\"");
		return dataSource;
	}
	*/
	@Bean(name="hssjdbcDS")
	public DataSource getHSSDataSource()	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://qtmnpeexplrdbwu2sql0.database.windows.net;databaseName=reportingdb");
        dataSource.setUsername("svc_reportingdb");
        dataSource.setPassword("TmoNEdSprintntm!6#$1");
		return dataSource;
	}
}
