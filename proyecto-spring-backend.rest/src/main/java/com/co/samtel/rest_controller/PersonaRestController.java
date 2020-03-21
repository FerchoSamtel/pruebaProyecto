package com.co.samtel.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.samtel.entity.PersonaEntity;
import com.co.samtel.service.IPersonaService;

@RestController
@RequestMapping("/person")
public class PersonaRestController {
	
	private IPersonaService personaService;

	@Autowired
	public PersonaRestController(IPersonaService personaService) {
		this.personaService = personaService;
	}
	
	@GetMapping("/persona")
	public List<PersonaEntity> findAll(){
		return personaService.findAll();
	}
	
	@GetMapping("/persona/{numeroDocumento}")
	public ResponseEntity<PersonaEntity> findById(@PathVariable("numeroDocumento") String numeroDocumento){
		return new ResponseEntity<PersonaEntity>(personaService.findById(numeroDocumento), HttpStatus.OK);
	}
	
	@PostMapping("/persona")
	public ResponseEntity<PersonaEntity> save(@RequestBody PersonaEntity personaEntity){
		return new ResponseEntity<PersonaEntity>(personaService.save(personaEntity), HttpStatus.CREATED);
	}
	
	@PutMapping("/persona/{numeroDocumento}")
	public ResponseEntity<PersonaEntity> update(@RequestBody PersonaEntity personaEntity, @PathVariable String numeroDocumento){
		PersonaEntity personaActual = personaService.findById(numeroDocumento);
		personaActual.setNumeroDocumento(personaEntity.getNumeroDocumento());
		personaActual.setTipoDocumento(personaEntity.getTipoDocumento());
		personaActual.setNombre(personaEntity.getNombre());
		personaActual.setEdad(personaEntity.getEdad());
		personaActual.setEmail(personaEntity.getEmail());
		personaActual.setSalario(personaEntity.getSalario());
		personaActual.setDescripcion(personaEntity.getDescripcion());
		return new ResponseEntity<PersonaEntity>(personaService.save(personaActual),HttpStatus.OK);
	}
	
	@DeleteMapping("persona/{numeroDocumento}")
	public ResponseEntity<PersonaEntity> deleteById(@PathVariable String numeroDocumento){
		personaService.deleteById(numeroDocumento);
		return ResponseEntity.noContent().build();
	}
	

}
