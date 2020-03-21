package com.co.samtel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.samtel.entity.PersonaEntity;
import com.co.samtel.repository.IPersonaRepository;
import com.co.samtel.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	private IPersonaRepository personaRepository;
	
	@Autowired
	public PersonaServiceImpl(IPersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public List<PersonaEntity> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public PersonaEntity findById(String numeroDocumento) {
		return personaRepository.findById(numeroDocumento).orElse(null);
	}

	@Override
	public PersonaEntity save(PersonaEntity personaEntity) {
		return personaRepository.save(personaEntity);
	}

	@Override
	public void deleteById(String numeroDocumento) {
		personaRepository.deleteById(numeroDocumento);
	}

}
