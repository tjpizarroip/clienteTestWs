package com.intercop.springboot.ws.oauth.clients.dto;

import java.io.Serializable;

public class Role implements Serializable {

	private Long id;

	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = -75924078800359817L;

}
