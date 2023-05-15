/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.service;

import com.portfolio.LucasMorales.entity.Persona;
import com.portfolio.LucasMorales.repo.IUsuarioRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
@Transactional
public class ImpUsuarioService{

    @Autowired 
    IUsuarioRepo iusuariorepo;

    public List<Persona>list(){
        return iusuariorepo.findAll();
    }
    public Optional<Persona> getOne(int id){
        return iusuariorepo.findById(id);
    }
    public Optional<Persona> getByNombre(String nombre){
        return iusuariorepo.findByNombre(nombre);
    }
    public void save(Persona persona){
        iusuariorepo.save(persona);
    }
    public void delete(int id){
    iusuariorepo.deleteById(id);
    }
    public boolean existsById(int id){
        return iusuariorepo.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return iusuariorepo.existsByNombre(nombre);
    }   
    
}


