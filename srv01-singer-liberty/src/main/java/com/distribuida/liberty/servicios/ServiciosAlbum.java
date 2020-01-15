package com.distribuida.liberty.servicios;

import java.util.List;

import com.distribuida.liberty.dto.Album;

public interface ServiciosAlbum {

	Album getAlbumById(Integer id);
	List<Album> getAlbums();
	
}
