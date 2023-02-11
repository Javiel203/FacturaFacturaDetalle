
package com.javiel.thymeleaf.dao;


import com.javiel.thymeleaf.dao.entity.CursoEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CursoDAO extends JpaRepository<CursoEntity, Integer> {

 //Consulta de Cursos por estado
 @Query("SELECT c FROM CursoEntity c WHERE c.estado = ?1")
 public List<CursoEntity> consultarPorEstado(int estado);
 

//Consulta de Cursos abiertos pero aún no completos
 //Lo trae desde el NamedQuery de la entidad !!
 public List<CursoEntity> abiertoIncompleto();

 //Consulta de Cursos después de la fecha X
 @Query("SELECT c FROM CursoEntity c WHERE c.fechaInicio >= :fecha")
 public List<CursoEntity> consultarPorFecha(@Param("fecha") Date fecha);

 //Consulta de Cursos a los que les falta X números de alumnos para llenarse
 //Nativa !!
 @Query(value = "SELECT * FROM Curso WHERE alumnosMin - alumnosAct = :cantidad",
 nativeQuery = true)
 public List<CursoEntity> consultarFaltantes(@Param("cantidad") Integer cantidad);

 //Consulta de Cursos por su nombre
 //Invocación a un Stored Procedure
 @Query(nativeQuery = true,value = "call Curso_Por_Nombre(:cadena)")
 public List<CursoEntity> consultarPorNombre(@Param("cadena") String cadena);

}