package com.distribuida.payara.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.payara.dto.Album;
import com.distribuida.payara.servicios.ServiciosAlbum;

@Path("albums")
@ApplicationScoped
public class ServiciosAlbumRest {
	
	@Inject ServiciosAlbum servicio;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> listarTodos(){
		List<Album> lista = servicio.getAlbums();
		return lista;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Album singerPorId(@PathParam ("id") Integer id) {
		Album sing = servicio.getAlbumById(id);
		return sing;
	}
	
}
