
package com.javiel.loginspring.controller;

import com.javiel.loginspring.model.UsuarioDTO;
import com.javiel.loginspring.service.UsuarioService;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    
    
    
    @RequestMapping("loginMostrar")
    public String loginMostrar(){
    
        return "login";
        
    }
    
    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(UsuarioDTO usuarioValida){
    
        ModelAndView mv = null;
        /** Ahora todo este proceso sera realizado por el bean
         * UsuarioDTO usuarioValida = new UsuarioDTO();
        usuarioValida.setUsuario(request.getParameter("txtUsuario"));
        usuarioValida.setClave(request.getParameter("txtClave"));*/
        
        UsuarioDTO ue = usuarioService.validarLogin(usuarioValida);
        
        if(ue==null){
        
            mv = new ModelAndView("login","msgError","Usuario y clave no existen. Vuelva a intentar!");
         }else{
        
            mv = new ModelAndView("usuarioLista", "lista",usuarioService.getListaUsuarios());
        
        }
        return mv;
        
    }
    //Para ingresar a la usuario lista sin usar login
   @RequestMapping("usuarioLista")
    public ModelAndView loginAccion(){
        return new ModelAndView( "usuarioLista", "lista", usuarioService.getListaUsuarios());
    }
    
    @RequestMapping("usuarioCrear")
    public ModelAndView crearUsuario(){
    
        return new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioDTO());
    
    }
    
    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@Valid @ModelAttribute("usuarioBean")
            UsuarioDTO usuario, BindingResult resulta){
    
       ModelAndView mv = null;
       
        if (resulta.hasErrors()) 
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        else
        {
        
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView ("usuarioLista","lista", usuarioService.getListaUsuarios());
        }
        
        return mv;
    
    }
    
    @RequestMapping("fotoMostrar")
    public String fotoMostrar(HttpServletRequest request, Model modelo) {
        modelo.addAttribute("usuario", usuarioService.getUsuario(request.getParameter("codigoUsuario")));
        return "eliminarUsuario";
    }

    @RequestMapping("fotoGrabar")
    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo,
            @RequestParam("codigoUsuario") String codigoUsuario) {

        UsuarioDTO usuario = usuarioService.getUsuario(codigoUsuario);
        usuario.setFoto(archivo.getBytes());

        return new ModelAndView("usuarioLista", "lista",
                usuarioService.getListaUsuarios());
    }
    
    
    
    @RequestMapping("usuarioEliminado")
    public String usuarioEliminado (String codigoUsuario){
        
       UsuarioDTO usuario  = usuarioService.getUsuario(codigoUsuario);
       usuarioService.eliminarUsuario(usuario);
        
        return "usuarioLista";
    }
    
}
