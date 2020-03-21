package com.co.samtel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.samtel.entity.UsuarioEntity;
import com.co.samtel.repository.IUsuarioRepository;
import com.co.samtel.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<UsuarioEntity> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UsuarioEntity findById(String usuario) {
		return usuarioRepository.findById(usuario).orElse(null);
	}

	@Override
	public UsuarioEntity save(UsuarioEntity usuarioEntity) {
		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public void deleteById(String usuario) {
		usuarioRepository.deleteById(usuario);
	}

}
