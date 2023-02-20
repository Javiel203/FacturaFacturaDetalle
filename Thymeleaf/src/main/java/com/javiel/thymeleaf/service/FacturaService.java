
package com.javiel.thymeleaf.service;

import com.javiel.thymeleaf.dao.DetalleFacturaDAO;
import com.javiel.thymeleaf.dao.FacturaDAO;
import com.javiel.thymeleaf.dao.entity.DetalleFacturaEntity;
import com.javiel.thymeleaf.dao.entity.FacturaEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaService {
  
    @Autowired
    private FacturaDAO facturaDAO;
    
    @Autowired
    private DetalleFacturaDAO detalleDAO;
    
    
    @Transactional
    public void insertarFactura (FacturaEntity factura, List<DetalleFacturaEntity> detalles){
    
       facturaDAO.save(factura);
   
       for (DetalleFacturaEntity detalle : detalles){
           detalle.setIdfactura(factura);
           detalleDAO.save(detalle);
       
       }
        
    }
    
}
