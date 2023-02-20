
package com.javiel.thymeleaf.dao;

import com.javiel.thymeleaf.dao.entity.DetalleFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DetalleFacturaDAO extends JpaRepository<DetalleFacturaEntity, Integer> {
    
}
