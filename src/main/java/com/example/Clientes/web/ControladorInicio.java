package com.example.Clientes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Clientes.domain.Persona;
import com.example.Clientes.servicio.PersonaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService; // inyectar una instancia de la clase PersonaServiceImpl

    @GetMapping("/")
    public String inicio(Model model) {
        List<Persona> personas = personaService.listarPersonas(); // Regresa la lista de objectos de tipo personas
        log.info("-------------------   Ejecutanto el inicio " + personas);
        System.out.println("----------------------------");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        List<Persona> personas = personaService.listarPersonas(); // Regresa la lista de objectos de tipo personas
        log.info("-------------------   Ejecutanto el controlador MVC " + personas);
        System.out.println("---------------------------- personas " + personas);
        // model.addAttribute("personas", personas);
        return "modificar";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        log.info("-------  Error del campo vacio " + errores.hasErrors());
        if (errores.hasErrors()) {
            log.info("-------  Ingreso ");
             return "modificar";
        }
        personaService.guardar(persona); // Guarda la informacion
        return "redirect:/"; // Redirecciona a la pagina de inicio
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) { // Al definir un obj. de tipo persona, si ya existe entoces
                                                         // Spring lo va inyectar

        persona = personaService.encontrarPersona(persona);
        // model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }

}
