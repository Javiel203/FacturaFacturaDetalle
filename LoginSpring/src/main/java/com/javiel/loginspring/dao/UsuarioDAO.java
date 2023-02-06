
package com.javiel.loginspring.dao;

import com.javiel.loginspring.model.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {
    
    private  List<UsuarioDTO> listaUsuarios;

    public UsuarioDAO() {
        
        listaUsuarios = new ArrayList<>();
        
        listaUsuarios.add(new UsuarioDTO("Beto", "12345", "Javier Peña"));
        
    }
    
    public void insertarUsuario(UsuarioDTO usuario){
        listaUsuarios.add(usuario);
    }
    
    public List<UsuarioDTO> getListaUsuarios(){
        return listaUsuarios;
    }
    
    public void eliminarUsuario(UsuarioDTO codigo){
        listaUsuarios.remove(codigo);
    }
    
    
    
    
    public UsuarioDTO validarLogin (UsuarioDTO usuario){
    
        if(usuario.getUsuario().equalsIgnoreCase("javier") &&
                usuario.getClave().equals("12345"))
            usuario.setNombreCompleto("Nombre completo del usuario");
    else
            usuario = null;
        
        return usuario;
        
    }
    
    public UsuarioDTO getUsuario (String codigo){
        
        UsuarioDTO rpta = null;
        
        for (UsuarioDTO usuario : listaUsuarios) {
            
            if (usuario.getUsuario().equals(codigo)){
                rpta = usuario;
                break;
            }
            
        }
        
        return rpta;
    
    }
    
}
