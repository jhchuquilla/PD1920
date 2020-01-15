package com.distribuida.payara.servicios;

import java.util.List;

import com.distribuida.payara.dto.Album;

public interface ServiciosAlbum {

	Album getAlbumById(Integer id);
	List<Album> getAlbums();
	
}
