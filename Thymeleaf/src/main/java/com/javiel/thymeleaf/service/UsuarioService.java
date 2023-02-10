package com.javiel.thymeleaf.service;

import com.javiel.thymeleaf.dao.UsuarioDAO;
import com.javiel.thymeleaf.dao.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public UsuarioEntity validarLogin(UsuarioEntity usuario) {
        UsuarioEntity rpta = usuarioDAO.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
        if (rpta == null) {
            return rpta;
        }
        if (!rpta.getClave().equalsIgnoreCase(usuario.getClave())) {
            rpta = null;
        }
        return rpta;
    }

    public void insertarUsuario(UsuarioEntity usuario) {
        usuarioDAO.save(usuario);
    }

    public List<UsuarioEntity> getListaUsuarios() {
        return usuarioDAO.findAll();
    }

     public List<UsuarioEntity> getListaUsuarios(Pageable pagina) {
        return usuarioDAO.findAll(pagina).getContent();
    }
     
    public UsuarioEntity getUsuario(String codigo) {
        UsuarioEntity rpta = null;
        Optional<UsuarioEntity> busqueda = usuarioDAO.findById(codigo);
        if (busqueda.isPresent()) {
            rpta = busqueda.get();
        }
        return rpta;
    }
    public void eliminarUsuario(String codigo){
    
        usuarioDAO.deleteById(codigo);
    
    }
    
}
