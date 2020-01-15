package com.distribuida.payara.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class Servidor1Application extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return Set.of(ServicioSingerRest.class);
	}
	
}
