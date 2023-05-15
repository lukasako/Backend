/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.service;

import com.portfolio.LucasMorales.entity.Experiencia;
import com.portfolio.LucasMorales.repo.RExperiencia;
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
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia>list(){
        return rExperiencia.findAll();
    }
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
    }
    public void save(Experiencia xp){
        rExperiencia.save(xp);
    }
    public void delete(int id){
    rExperiencia.deleteById(id);
    }
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);
    }    
}
