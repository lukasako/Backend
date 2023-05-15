/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.service;

import com.portfolio.LucasMorales.Interface.IUsuarioService;
import com.portfolio.LucasMorales.entity.Persona;
import com.portfolio.LucasMorales.repo.IUsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ImpUsuarioService implements IUsuarioService{

    @Autowired IUsuarioRepo iusuariorepo;
    
    @Override
    public List<Persona> getUsuario() {
        List<Persona> usuario= iusuariorepo.findAll();
        return usuario;
    }

    @Override
    public void saveUsuario(Persona usuario) {
        iusuariorepo.save(usuario);
    }

    @Override
    public void deleteUsuario(int id) {
        iusuariorepo.deleteById(id);
    }

    
    public Persona findUsuario(Integer id) {
        Persona Usuario = iusuariorepo.findById(id).orElse(null);
        return Usuario;
    }

    
}


