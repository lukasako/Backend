/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.Interface;


import com.portfolio.LucasMorales.entity.Persona;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IUsuarioService {
    public List<Persona> getUsuario();
    
    public void saveUsuario(Persona usuario);
    
    public void deleteUsuario(int id);
    
    public Persona findUsuario(Integer id);
}
