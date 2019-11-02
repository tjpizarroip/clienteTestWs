package com.intercop.springboot.ws.cliente.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.intercop.springboot.ws.cliente.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
	
	@Query("select c.edad from Cliente c")
	public List<Integer> getEdadesCliente();
	
}
