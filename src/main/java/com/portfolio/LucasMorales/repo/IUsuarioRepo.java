/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.repo;


import com.portfolio.LucasMorales.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface IUsuarioRepo extends JpaRepository <Persona, Integer>{

    public void deleteById(int id);

    public Object findById(int id);

    public Persona findAllById(int id);
}
