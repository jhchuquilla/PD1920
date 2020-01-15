package com.distribuida.payara.servicios;

import java.util.List;

import com.distribuida.payara.dto.Singer;

public interface ServiciosSinger {
	
	Singer getSingerById(Integer id);
	List<Singer> getSingers();
	
}
