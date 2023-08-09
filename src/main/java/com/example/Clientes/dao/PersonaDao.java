package com.example.Clientes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.Clientes.domain.Persona;


@Repository
public interface PersonaDao extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona>{
}
