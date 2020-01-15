package com.distribuida.liberty.conexion;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class DbProducerSrv01 {
	
	static final String URL = "jdbc:postgresql://localhost:5432/examen01";
	static final String USER = "postgres";
	static final String PASSWORD = "nelita2108";
	
	@ApplicationScoped
	@Produces
	public DataSource dataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUsername(USER);
		ds.setPassword(PASSWORD);
		ds.setUrl(URL);
		
		return ds;
	}
	
}
