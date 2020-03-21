package com.co.samtel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter @Setter
public class PersonaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "numero_documento")
	private String numeroDocumento;
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "edad")
	private String edad;
	@Column(name = "email")
	private String email;
	@Column(name = "salario")
	private double salario;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name = "descripcion")
	private String descripcion;
}
