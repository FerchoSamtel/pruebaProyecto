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

import com.co.samtel.entity.UsuarioEntity;
import com.co.samtel.service.IUsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioRestControlller {
	
	private IUsuarioService iUsuarioService;

	@Autowired
	public UsuarioRestControlller(IUsuarioService iUsuarioService) {
		this.iUsuarioService = iUsuarioService;
	}
	
	@GetMapping("/usuario")
	public List<UsuarioEntity> findAll(){
		return iUsuarioService.findAll();
	}
	
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<UsuarioEntity> findById(@PathVariable("usuario") String usuario){
		return new ResponseEntity<UsuarioEntity>(iUsuarioService.findById(usuario), HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioEntity> save(@RequestBody UsuarioEntity usuario){
		return new ResponseEntity<UsuarioEntity>(iUsuarioService.save(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping("/usuario/{usuario}")
	public ResponseEntity<UsuarioEntity> update(@RequestBody UsuarioEntity usuario, @PathVariable("usuario") String usuarios){
		UsuarioEntity usuarioActual = iUsuarioService.findById(usuarios);
		usuarioActual.setUsuario(usuario.getUsuario());
		usuarioActual.setNumeroDocumento(usuario.getNumeroDocumento());
		usuarioActual.setPerfil(usuario.getPerfil());
		usuarioActual.setHabilitado(usuario.getHabilitado());
		return new ResponseEntity<UsuarioEntity>(iUsuarioService.save(usuarioActual),HttpStatus.CREATED);
	}

	
	@DeleteMapping("usuario/{usuario}")
	public ResponseEntity<Void> deleteByIdd(@PathVariable("usuario") String usuario){
		iUsuarioService.deleteById(usuario);
		return ResponseEntity.notFound().build();
	}
}
