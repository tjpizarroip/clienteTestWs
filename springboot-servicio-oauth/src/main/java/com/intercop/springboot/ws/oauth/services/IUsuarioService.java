package com.intercop.springboot.ws.oauth.services;

import com.intercop.springboot.ws.oauth.clients.dto.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	public Usuario update(Usuario usuario, Long id);
}
