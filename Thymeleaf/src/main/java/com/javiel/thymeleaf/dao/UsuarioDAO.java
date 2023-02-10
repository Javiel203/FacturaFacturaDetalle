
package com.javiel.thymeleaf.dao;

import com.javiel.thymeleaf.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;





public interface UsuarioDAO extends JpaRepository<UsuarioEntity, String> {
    
    public UsuarioEntity findByUsuarioAndClave(String miUsuario, String miClave);
    
}
