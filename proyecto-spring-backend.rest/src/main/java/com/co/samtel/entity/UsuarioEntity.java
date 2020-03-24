package com.co.samtel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class UsuarioEntity implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "numero_documento")
	private String numeroDocumento;
	@Column(name = "perfil")
	private byte perfil;
	@Column(name = "habilitado")
	private byte habilitado;
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@PrePersist
	public void fechaCreacion() {
		fechaCreacion = new Date();
	}
	
}
