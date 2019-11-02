package com.intercop.springboot.ws.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import com.intercop.springboot.ws.cliente.models.entity.Cliente;
import com.intercop.springboot.ws.cliente.models.service.IClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="Customer Management System")
public class ClienteController {
	
	@Autowired
	private IClienteService serviceCliente;
	
	@GetMapping("/listar")
	@ApiOperation(value = "Lista de Clientes", response = List.class)
	public List<Cliente> listar(){
		return serviceCliente.findAll();
	}
	
	@GetMapping("/listClientes")
	@ApiOperation(value = "Lista de Clientes con posible muerte", response = List.class)
	public List<Cliente> listClientes(){
		return serviceCliente.listClienteConFechaMuerte();
	}
	
	@GetMapping("/kpideclientes")
	@ApiOperation(value = "Retorna el promedio y la desviacion", response = Map.class)
	public Map<String, Double> kpideclientes(){
		return serviceCliente.getPromedioDesviacionEdades();
	}
	
	@PostMapping("/creacliente")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Crea cliente nuevo")
	public Cliente creacliente(
			@ApiParam(value = "Objecto de Cliente a persistir", required = true) 
			@Valid 
			@RequestBody Cliente cliente) {
		return serviceCliente.save(cliente);
	}
	
}
