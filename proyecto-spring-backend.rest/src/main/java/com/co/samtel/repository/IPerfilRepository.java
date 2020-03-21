package com.co.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.samtel.entity.PerfilEntity;

@Repository
public interface IPerfilRepository  extends JpaRepository<PerfilEntity, Byte>{

}
