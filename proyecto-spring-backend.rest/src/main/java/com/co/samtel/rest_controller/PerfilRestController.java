package com.co.samtel.rest_controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.co.samtel.entity.PerfilEntity;
import com.co.samtel.service.IPerfilService;

@RestController
@RequestMapping("/profile")
@CrossOrigin("http://localhost:4200")
public class PerfilRestController {
	
	private IPerfilService perfilService;

	@Autowired
	public PerfilRestController(IPerfilService perfilService) {
		this.perfilService = perfilService;
	}
	
	@GetMapping("/perfil")
	public List<PerfilEntity> findAll(){
		return perfilService.findAll();
	}
	
	@GetMapping("/perfil/{codigoPerfil}")
	public ResponseEntity<PerfilEntity> findById(@PathVariable("codigoPerfil") Byte codigoPerfil){
		return new ResponseEntity<PerfilEntity>(perfilService.findById(codigoPerfil), HttpStatus.OK);
	}
	
	@PostMapping("/perfil")
	public ResponseEntity<PerfilEntity> save(@RequestBody PerfilEntity perfilEntity){
		return new ResponseEntity<PerfilEntity>(perfilService.save(perfilEntity), HttpStatus.CREATED);
	}
	
	@PutMapping("/perfil/{codigoPerfil}")
	public ResponseEntity<PerfilEntity> update(@RequestBody PerfilEntity perfilEntity, @PathVariable("codigoPerfil") Byte codigoPerfil){
		PerfilEntity perfilActual = perfilService.findById(codigoPerfil);
		perfilActual.setCodigoPerfil(perfilEntity.getCodigoPerfil());
		perfilActual.setDescripcion(perfilEntity.getDescripcion());
		return new ResponseEntity<PerfilEntity>(perfilService.save(perfilActual),HttpStatus.CREATED);
	}

	
	@DeleteMapping("perfil/{codigoPerfil}")
	public ResponseEntity<Void> deleteByIdd(@PathVariable("codigoPerfil") Byte codigoPerfil){
		perfilService.deleteById(codigoPerfil);
		return ResponseEntity.ok().build();
	}


}
