package com.co.samtel.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@Getter @Setter
public class PerfilEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "codigo_perfil")
	private Byte codigoPerfil;
	@Column(name = "descripcion")
	private String descripcion;

	
}
