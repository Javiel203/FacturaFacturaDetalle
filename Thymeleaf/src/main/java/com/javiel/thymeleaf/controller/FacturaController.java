
package com.javiel.thymeleaf.controller;


import com.javiel.thymeleaf.dao.entity.DetalleFacturaEntity;
import com.javiel.thymeleaf.dao.entity.FacturaEntity;
import com.javiel.thymeleaf.service.FacturaService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FacturaController {
    
    @Autowired
    private FacturaService facturaService;
    
    @RequestMapping("registrarFactura")
    public ModelAndView factura(){
        return new ModelAndView("registroFactura", "facturaBean", new FacturaEntity());
    }
    
    @PostMapping("grabarFactura")
    public ModelAndView grabarFactura(@Valid @ModelAttribute("facturaBean") FacturaEntity factura,
                          BindingResult resulta, ModelMap modelo, HttpServletRequest request){
    
        ModelAndView mv = null;
        
        if (resulta.hasErrors()) {
         
            mv = new ModelAndView("registroFactura", "facturaBean", factura);
            
        }else{
            
            List<DetalleFacturaEntity> detalles = new ArrayList<DetalleFacturaEntity>();
            
            DetalleFacturaEntity item1 = new DetalleFacturaEntity();
            item1.setCantidad(Integer.parseInt(request.getParameter("cantidad1")));
            item1.setProducto(request.getParameter("producto1"));
            item1.setPunitario(Integer.parseInt(request.getParameter("punitario1")));
            item1.setPparcial(Integer.parseInt(request.getParameter("pparcial1")));
            detalles.add(item1);
            
            DetalleFacturaEntity item2 = new DetalleFacturaEntity();
            item2.setCantidad(Integer.parseInt(request.getParameter("cantidad2")));
            item2.setProducto(request.getParameter("producto2"));
            item2.setPunitario(Integer.parseInt(request.getParameter("punitario2")));
            item2.setPparcial(Integer.parseInt(request.getParameter("pparcial2")));
            detalles.add(item2);
            
             DetalleFacturaEntity item3 = new DetalleFacturaEntity();
            item3.setCantidad(Integer.parseInt(request.getParameter("cantidad3")));
            item3.setProducto(request.getParameter("producto3"));
            item3.setPunitario(Integer.parseInt(request.getParameter("punitario3")));
            item3.setPparcial(Integer.parseInt(request.getParameter("pparcial3")));
            detalles.add(item3);
            
            facturaService.insertarFactura(factura, detalles );
            mv = new ModelAndView("registroFactura", "facturaBean", new FacturaEntity());
            
            
        }
        
        return mv;
    }
}

