package com.co.samtel.rest_controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.co.samtel.entity.PersonaEntity;
import com.co.samtel.service.IPersonaService;

@RestController
@RequestMapping("/person")
@CrossOrigin("http://localhost:4200")
public class PersonaRestController {

	private IPersonaService personaService;

	@Autowired
	public PersonaRestController(IPersonaService personaService) {
		this.personaService = personaService;
	}

	@GetMapping("/persona")
	public List<PersonaEntity> findAll() {
		return personaService.findAll();
	}

	@GetMapping("/persona/{numeroDocumento}")
	public ResponseEntity<PersonaEntity> findById(@PathVariable("numeroDocumento") String numeroDocumento) {
		return new ResponseEntity<PersonaEntity>(personaService.findById(numeroDocumento), HttpStatus.OK);
	}

	@PostMapping("/persona")
	public ResponseEntity<PersonaEntity> save(@RequestBody PersonaEntity personaEntity) {
		return new ResponseEntity<PersonaEntity>(personaService.save(personaEntity), HttpStatus.CREATED);
	}

	@PutMapping("/persona/{numeroDocumento}")
	public ResponseEntity<PersonaEntity> update(@RequestBody PersonaEntity personaEntity,
			@PathVariable String numeroDocumento) {
		PersonaEntity personaActual = personaService.findById(numeroDocumento);
		personaActual.setNumeroDocumento(personaEntity.getNumeroDocumento());
		personaActual.setTipoDocumento(personaEntity.getTipoDocumento());
		personaActual.setNombre(personaEntity.getNombre());
		personaActual.setEdad(personaEntity.getEdad());
		personaActual.setEmail(personaEntity.getEmail());
		personaActual.setSalario(personaEntity.getSalario());
		personaActual.setDescripcion(personaEntity.getDescripcion());
		return new ResponseEntity<PersonaEntity>(personaService.save(personaActual), HttpStatus.OK);
	}

	@DeleteMapping("persona/{numeroDocumento}")
	public ResponseEntity<PersonaEntity> deleteById(@PathVariable String numeroDocumento) {
		personaService.deleteById(numeroDocumento);
		return ResponseEntity.ok().build();
	}

//	METODO PARA PROCESAR EL ARCHIVO PLANO 
	@PostMapping(value =  "/upload", consumes = "text/csv")
	public String setData(@RequestParam("file") @Valid MultipartFile file) throws NumberFormatException, IOException {
		personaService.saveCsvData(file);
		String result = "Hecho: " + file.getOriginalFilename();
		return result;
	}

	@PostMapping("/PruebaFile")
	public String uploadFile(@RequestParam("file") @Valid MultipartFile file) throws NumberFormatException, IOException {
		personaService.saveCsvData(file);
		String result = "Hecho: " + file.getOriginalFilename();
		return result;
	}

//	@PostMapping(value = "/upload", consumes = "text/csv")
//	public void upload(@RequestBody InputStream body) throws IOException {
//		personareposit.saveAll(Csv.read(PersonaEntity.class, body));
//	}
//
//	@PostMapping(value = "/upload", consumes = "multipart/form-data")
//    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
//		personareposit.saveAll(Csv.read(PersonaEntity.class, file.getInputStream()));
//    }
}
