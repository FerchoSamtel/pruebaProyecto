package com.co.samtel.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	String linea = "";

//	@Override
//	public void saveCsvData() throws IOException  {
//		try {
//			BufferedReader br = new BufferedReader(new FileReader ("src/main/resources/persona.csv"));
//			while((linea = br.readLine()) != null) {
//				String [] data = linea.split(",");
//				PersonaEntity personaEntity = new PersonaEntity();
//				personaEntity.setNumeroDocumento(data[0]);
//				personaEntity.setTipoDocumento(data[1]);
//				personaEntity.setNombre(data[2]);
//				personaEntity.setEdad(data[3]);
//				personaEntity.setEmail(data[4]);
//				personaEntity.setSalario(Integer.parseInt(data[5]));
//				personaEntity.setFechaNacimiento(data[6]);
//				personaEntity.setDescripcion(data[7]);
//				personaRepository.save(personaEntity);				
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}		
//	}

	@Override
	public void saveCsvData(MultipartFile file) throws NumberFormatException, IOException {
		try {
			BufferedReader br = new BufferedReader((Reader) file);
			while ((linea = br.readLine()) != null) {
				String[] data = linea.split(",");
				PersonaEntity personaEntity = new PersonaEntity();
				personaEntity.setNumeroDocumento(data[0]);
				personaEntity.setTipoDocumento(data[1]);
				personaEntity.setNombre(data[2]);
				personaEntity.setEdad(data[3]);
				personaEntity.setEmail(data[4]);
				personaEntity.setSalario(Integer.parseInt(data[5]));
				personaEntity.setFechaNacimiento(data[6]);
				personaEntity.setDescripcion(data[7]);
				personaRepository.save(personaEntity);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
