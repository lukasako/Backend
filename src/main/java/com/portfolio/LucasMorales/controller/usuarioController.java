/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.controller;

import com.portfolio.LucasMorales.Interface.IUsuarioService;
import com.portfolio.LucasMorales.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins= "https://frontend-2b443.web.app")
public class usuarioController {
    @Autowired IUsuarioService iusuarioservice;
    
    @GetMapping("/usuario/traer")
    public List<Persona> getUsuario(){
        return iusuarioservice.getUsuario();
    }
    

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody Persona usuario) {
        iusuarioservice.saveUsuario(usuario);
        return "El usuario fue guardado con exito";
    }
    
    /**
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    @DeleteMapping("/usuario/borrar/{id}")
    public String deleteUsuario(@PathVariable int id){
 
        iusuarioservice.deleteUsuario(id);
        return "El usuario fue borrado con exito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuario/editar/{id}")
    public Persona editUsuario(@PathVariable int id, @RequestParam("nombre") String NuevoNombre, @RequestParam("apellido") String NuevoApellido,@RequestParam("img") String NuevoImg){
        Persona usuario =  iusuarioservice.findUsuario(id);
        usuario.setNombre(NuevoNombre);
        usuario.setApellido(NuevoApellido);
        usuario.setImg(NuevoImg);
        
        iusuarioservice.saveUsuario(usuario);
        return usuario;
    }
    
    
    @GetMapping("/usuario/traer/perfil")
    public Persona findPersona(){
        return iusuarioservice.findUsuario((int)2);
    }
}
