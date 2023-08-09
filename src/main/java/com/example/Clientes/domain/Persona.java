package com.example.Clientes.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "persona")
public class Persona implements Serializable {

  private static final long serialVersionUID = 1L;

  // Podemos mapear a la base de datos con la tabla de persona
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  @Column(name = "id_persona")
  private Long idPersona;
  
  
  @Column(name = "nombre", nullable = false)
  @NotEmpty
  private String nombre;
   

  @Column(name = "apellido", nullable = false)
  @NotEmpty
  private String apellido;


  @Column(name = "email", nullable = false)
  @NotEmpty
  private String email;

  @Column(name = "telefono", nullable = false)
  @NotEmpty
  private String telefono;



  public Long getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Long idPersona) {
    this.idPersona = idPersona;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
 
}
