/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.controller;

import com.portfolio.LucasMorales.Dto.DtoUsuario;
import com.portfolio.LucasMorales.Security.Controller.Mensaje;
import com.portfolio.LucasMorales.entity.Persona;
import com.portfolio.LucasMorales.service.ImpUsuarioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins= "https://frontend-2b443.web.app")
public class usuarioController {
    
    @Autowired
    ImpUsuarioService sPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona educacion = sPersona.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoUsuario dtousuario){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(sPersona.existsByNombre(dtousuario.getNombre()) && sPersona
                .getByNombre(dtousuario.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtousuario.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona educacion = sPersona.getOne(id).get();
        educacion.setNombre(dtousuario.getNombre());
        educacion.setDescripcion(dtousuario.getDescripcion());
        
        sPersona.save(educacion);
        return new ResponseEntity(new Mensaje("Se actualizo con exito"), HttpStatus.OK);
    }
    
}
