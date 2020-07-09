package com.intercop.springboot.ws.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.intercop.springboot.ws.usuarios.models.entity.Usuario;


@RepositoryRestResource(path = "usuario")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{
	/*
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods 
	 * http://localhost:9070/api/usuarios/usuario/search/findByUsername?username=admin
	 * En caso de no colocar el RestResource y ni el param
	 **/
	@RestResource(path = "buscar-username") public Usuario findByUsername(@Param("nombre") String username);
	
	@Query("select u from Usuario u where u.username = ?1")
	public Usuario obtenerPorUsername(String username);
}
