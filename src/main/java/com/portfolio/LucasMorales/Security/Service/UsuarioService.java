/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.LucasMorales.Security.Service;

import com.portfolio.LucasMorales.Security.Entity.Usuario;
import com.portfolio.LucasMorales.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas Morales
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByUserName(String userName) {
        return iusuarioRepository.findByUserName(userName);
    }

    public boolean existsByUserName(String userName) {
        return iusuarioRepository.existsByUserName(userName);
    }

    public boolean existsByMail(String mail) {
        return iusuarioRepository.existsByMail(mail);
    }
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
