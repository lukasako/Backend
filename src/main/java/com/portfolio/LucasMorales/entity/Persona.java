/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PC
 */
@Getter @Setter
@Entity
/**
 *
 * @author PC
 */
public class Persona {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min=1, max=50, message="por favor verifique los campos")
    private String nombre;
    
    @NotNull
    @Size(min=1, max=50, message="por favor verifique los campos")
    private String apellido;
   
    @Size(min=1, max=50, message="por favor verifique los campos")
    private String img;
    
    
}
