package com.co.samtel.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.co.samtel.entity.PerfilEntity;
import com.co.samtel.repository.IPerfilRepository;
import com.co.samtel.service.IPerfilService;
@Service
public class PerfilServiceImpl implements IPerfilService {

	private IPerfilRepository perfilRepository;
	
	@Autowired
	public PerfilServiceImpl(IPerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}

	@Override
	public List<PerfilEntity> findAll() {
		return perfilRepository.findAll();
	}

	@Override
	public PerfilEntity findById(Byte codigoPerfil) {
		return perfilRepository.findById(codigoPerfil).orElse(null);
	}

	@Override
	public PerfilEntity save(PerfilEntity perfilEntity) {
		return perfilRepository.save(perfilEntity);
	}

	@Override
	public void deleteById(Byte codigoPerfil) {
		perfilRepository.deleteById(codigoPerfil);
	}
}
