/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.service;

import com.portfolio.LucasMorales.entity.Skills;
import com.portfolio.LucasMorales.repo.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Transactional
@Service
public class SSkills {

    @Autowired
    RSkills skills;

    public List<Skills> list() {
        return skills.findAll();
    }

    public Optional<Skills> getOne(int id) {
        return skills.findById(id);
    }

    public Optional<Skills> getByNombre(String nombre) {
        return skills.findByNombre(nombre);
    }

    public void save(Skills skill) {
        skills.save(skill);
    }

    public void delete(int id) {
        skills.deleteById(id);
    }

    public boolean existsById(int id) {
        return skills.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return skills.existsByNombre(nombre);
    }
}
