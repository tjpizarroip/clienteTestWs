package com.intercop.springboot.ws.cliente.models.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercop.springboot.ws.cliente.models.dao.ClienteDao;
import com.intercop.springboot.ws.cliente.models.entity.Cliente;
import com.intercop.springboot.ws.commons.utilities.Util;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	private static final String FORMATO_FECHA = "yyyy-MM-dd";

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Map<String, Double> getPromedioDesviacionEdades() {
		List<Integer> edades = clienteDao.getEdadesCliente();
		Map<String, Double> data = new HashMap<String, Double>();
		data.put("promedio", Util.promedio(edades));
		data.put("desviacion", Util.desviacion(edades));
		return data;
	}

	@Override
	public List<Cliente> listClienteConFechaMuerte() {
		List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
		for (Cliente cliente : clientes) {
			Date fechaPosibleFallecimiento = new Date();
			Date now = new Date();
			do {
				fechaPosibleFallecimiento = Util.fechaPosibleFallecimiento(cliente.getFechaNacimiento());
				System.out.println("Fecha Nacimiento: "+Util.formatFecha(cliente.getFechaNacimiento(), FORMATO_FECHA) + " - "+Util.formatFecha(fechaPosibleFallecimiento, FORMATO_FECHA));
			}while(now.compareTo(fechaPosibleFallecimiento) > 0);			
			
			cliente.setFechaPosibleMuerte(Util.formatFecha(Util.fechaPosibleFallecimiento(cliente.getFechaNacimiento()), FORMATO_FECHA));
		}
		return clientes;
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

}
