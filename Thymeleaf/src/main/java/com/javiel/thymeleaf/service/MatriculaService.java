package com.javiel.thymeleaf.service;

import com.javiel.thymeleaf.dao.AuditoriaDAO;
import com.javiel.thymeleaf.dao.MatriculaDAO;
import com.javiel.thymeleaf.dao.entity.AuditoriaEntity;
import com.javiel.thymeleaf.dao.entity.MatriculaEntity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaDAO matriculaDAO;
    
    @Autowired
    private AuditoriaDAO auditoriaDAO;

    public List<MatriculaEntity> listaTodas() {
        return matriculaDAO.findAll();
    }

    @Transactional
    public void grabarMatricula(MatriculaEntity me) {
        matriculaDAO.save(me);
        
        AuditoriaEntity ae = new AuditoriaEntity(0, new Date(Calendar.getInstance().getTimeInMillis()), 
                    me.getUsuario(), "Insertar Matricula "+me.getIdMatricula());
        auditoriaDAO.save(ae);
    }
}
