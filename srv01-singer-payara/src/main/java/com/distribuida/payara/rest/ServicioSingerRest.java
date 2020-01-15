package com.distribuida.payara.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.payara.dto.Singer;
import com.distribuida.payara.servicios.ServiciosSinger;

@Path("singer")
public class ServicioSingerRest {
	
	@Inject private ServiciosSinger servicio;
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String saludar() {
		return "hola mundo con payara micro";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listarTodos(){
		List<Singer> lista = servicio.getSingers();
		return lista;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Singer singerPorId(@PathParam ("id") Integer id) {
		Singer sing = servicio.getSingerById(id);
		return sing;
	}
	
}
