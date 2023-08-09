package com.example.Clientes.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Clientes.dao.PersonaDao;
import com.example.Clientes.domain.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true) // Solo lectura
    public List<Persona> listarPersonas() { // leer o listar informacion de la base de datos
        // Realizamos el casteo para convertir a una lista
        return  personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) { // Insertar informacion en la base de datos
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) { // Eliminar informacion en la base de datos
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) { // Consulta informacion de la base de datos
        return personaDao.findById(persona.getIdPersona()).orElse(null);

    }

}
