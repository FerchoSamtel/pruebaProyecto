package com.co.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.samtel.entity.PersonaEntity;

@Repository
public interface IPersonaRepository extends JpaRepository<PersonaEntity, String>{

}
