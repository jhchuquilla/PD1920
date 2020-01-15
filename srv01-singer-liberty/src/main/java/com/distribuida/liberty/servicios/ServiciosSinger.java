package com.distribuida.liberty.servicios;

import java.util.List;

import com.distribuida.liberty.dto.Singer;

public interface ServiciosSinger {
	
	Singer getSingerById(Integer id);
	List<Singer> getSingers();
	
}
