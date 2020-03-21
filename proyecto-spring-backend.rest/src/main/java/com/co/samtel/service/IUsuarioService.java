package com.co.samtel.service;

import java.util.List;

import com.co.samtel.entity.UsuarioEntity;

public interface IUsuarioService {
	
	public List<UsuarioEntity> findAll();
	public UsuarioEntity findById(String usuario);
	public UsuarioEntity save(UsuarioEntity usuarioEntity);
	public void deleteById(String usuario);
}
