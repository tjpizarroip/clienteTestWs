package com.intercop.springboot.ws.cliente.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes="Nombre es obligatorio")
	private String nombre;
	@ApiModelProperty(notes="Apellido es obligatorio")
	private String apellido;
	@ApiModelProperty(notes="Clientes deberias ser Adultos")
	private Integer edad;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	@ApiModelProperty(notes="Fecha Nacimiento deberia ser en el pasado")
	private Date fechaNacimiento;

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaPosibleMuerte() {
		return fechaPosibleMuerte;
	}

	public void setFechaPosibleMuerte(String fechaPosibleMuerte) {
		this.fechaPosibleMuerte = fechaPosibleMuerte;
	}

	@Transient
	private String fechaPosibleMuerte;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	private static final long serialVersionUID = 1L;
	
}
