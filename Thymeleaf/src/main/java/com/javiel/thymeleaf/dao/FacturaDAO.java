
package com.javiel.thymeleaf.dao;

import com.javiel.thymeleaf.dao.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturaDAO extends JpaRepository<FacturaEntity, Integer> {
    
}
