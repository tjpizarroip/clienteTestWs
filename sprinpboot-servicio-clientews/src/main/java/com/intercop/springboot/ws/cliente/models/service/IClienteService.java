package com.intercop.springboot.ws.cliente.models.service;

import java.util.List;
import java.util.Map;

import com.intercop.springboot.ws.cliente.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	public Map<String, Double> getPromedioDesviacionEdades();
	public List<Cliente> listClienteConFechaMuerte();
	public Cliente save(Cliente cliente);
}
