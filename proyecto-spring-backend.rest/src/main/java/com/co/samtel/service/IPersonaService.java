package com.co.samtel.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.co.samtel.entity.PersonaEntity;

public interface IPersonaService {

	public List<PersonaEntity> findAll();
	public PersonaEntity findById(String numeroDocumento);
	public PersonaEntity save(PersonaEntity personaEntity);
	public void deleteById(String numeroDocumento);
//	void saveCsvData(FileReader file) throws NumberFormatException, IOException;
	void saveCsvData(MultipartFile file) throws NumberFormatException, IOException;
}
