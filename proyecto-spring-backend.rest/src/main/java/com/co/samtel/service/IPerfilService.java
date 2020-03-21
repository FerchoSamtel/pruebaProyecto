package com.co.samtel.service;

import java.util.List;

import com.co.samtel.entity.PerfilEntity;

public interface IPerfilService {
 
	public List<PerfilEntity> findAll();
	public PerfilEntity findById(Byte codigoPerfil);
	public PerfilEntity save(PerfilEntity perfilEntity);
	public void deleteById(Byte codigoPerfil);
}
