package com.co.samtel.service;

import java.util.List;

import com.co.samtel.entity.PersonaEntity;

public interface IPersonaService {

	public List<PersonaEntity> findAll();
	public PersonaEntity findById(String numeroDocumento);
	public PersonaEntity save(PersonaEntity personaEntity);
	public void deleteById(String numeroDocumento);
}
