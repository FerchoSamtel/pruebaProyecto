package com.co.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.samtel.entity.UsuarioEntity;

@Repository
public interface IUsuarioRepository  extends JpaRepository<UsuarioEntity, String>{

}
