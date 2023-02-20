package com.javiel.thymeleaf.controller;


import com.javiel.thymeleaf.service.CursoService;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CursoController {

     
    
    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoMostrar")
    public String cursoMostrar() {
        return "cursoBusqueda";
    }

    @RequestMapping("cursoBusqueda")
    public ModelAndView loginAccion(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("cursoBusqueda", "cursoBean", request);
        StringBuilder tipoBusqueda = new StringBuilder();
        String tipoConsulta = request.getParameter("tipo");
        
        switch (tipoConsulta) {
            case "estado":
                int estado = Integer.parseInt(request.getParameter("estado"));
                mv.addObject("lista", cursoService.consultarPorEstado(estado));
                mv.addObject("tipoBusqueda", tipoBusqueda.append(" por estado "+estado));
                
                break;
            case "incompleto":
                mv.addObject("lista", cursoService.consultarAbiertoIncompleto());
                mv.addObject("tipoBusqueda", tipoBusqueda.append(" incompletos"));
                break;
            case "porfecha":
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                mv.addObject("lista", cursoService.consultarPorFecha(fecha));
                mv.addObject("tipoBusqueda", tipoBusqueda.append("por fecha de "+fecha));
                break;
            case "faltante":
                int faltante = Integer.parseInt(request.getParameter("numero"));
                mv.addObject("lista", cursoService.consultarFaltantes(faltante));
                mv.addObject("tipoBusqueda", tipoBusqueda.append("por "+ faltante +" alumnos faltantes"));
                break;
            case "nombre":
                String cadena = request.getParameter("cadena");
                mv.addObject("lista", cursoService.consultarPorNombre(cadena));
                mv.addObject("tipoBusqueda", tipoBusqueda.append(" por nombre "+cadena) );
                
                break;
            default:
                mv.addObject("lista", null);
                break;
        }
        return mv;
    }
}
