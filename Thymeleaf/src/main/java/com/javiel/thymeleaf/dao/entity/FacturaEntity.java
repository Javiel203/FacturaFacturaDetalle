
package com.javiel.thymeleaf.dao.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table (name ="factura")
public class FacturaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfactura;
    @NotBlank
    private String cliente;
    private Integer monto;
    @NotBlank
    private String moneda;
    
    private Date fecha;
    
    

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("FacturaEntity{idfactura").append(idfactura);
        sb.append(", cliente=").append(cliente);
        sb.append(", monto=").append(monto);
        sb.append(", moneda=").append(moneda);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }

    public FacturaEntity() {
        this.items = new ArrayList<DetalleFacturaEntity>();
    }

    public FacturaEntity(Integer idfactura, String cliente, Integer monto, String moneda, Date fecha) {
        this.idfactura = idfactura;
        this.cliente = cliente;
        this.monto = monto;
        this.moneda = moneda;
        this.fecha = fecha;
    }
    
    @OneToMany(mappedBy = "idfactura", cascade = CascadeType.ALL)
    private List<DetalleFacturaEntity> items;
    
    

    public List<DetalleFacturaEntity> getItems() {
        return items;
    }

    public void setItems(List<DetalleFacturaEntity> items) {
        this.items = items;
    }
    
    public void addDetalleFacturaEntity(DetalleFacturaEntity item){
        this.items.add(item);
    }
    
}
