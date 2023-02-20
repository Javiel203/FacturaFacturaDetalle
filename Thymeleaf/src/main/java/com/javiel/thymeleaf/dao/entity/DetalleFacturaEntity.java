
package com.javiel.thymeleaf.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "facturadetalle")
public class DetalleFacturaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfacturaDetalle")
    private int idFacDetalle;
    private int cantidad;
    private String producto;
    private int punitario;
    private int pparcial;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfactura")
    private FacturaEntity idfactura;

    public DetalleFacturaEntity() {
    }

    
    public DetalleFacturaEntity(int idFacDetalle, int cantidad, String producto, int punitario, int pparcial, FacturaEntity idfactura) {
        this.idFacDetalle = idFacDetalle;
        this.cantidad = cantidad;
        this.producto = producto;
        this.punitario = punitario;
        this.pparcial = pparcial;
        this.idfactura = idfactura;
    }   

    public FacturaEntity getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(FacturaEntity idfactura) {
        this.idfactura = idfactura;
    }
 
    
    public int getIdFacDetalle() {
        return idFacDetalle;
    }

    public void setIdFacDetalle(int idFacDetalle) {
        this.idFacDetalle = idFacDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPunitario() {
        return punitario;
    }

    public void setPunitario(int punitario) {
        this.punitario = punitario;
    }

    public int getPparcial() {
        return pparcial;
    }

    public void setPparcial(int pparcial) {
        this.pparcial = pparcial;
    }
  
    
}
