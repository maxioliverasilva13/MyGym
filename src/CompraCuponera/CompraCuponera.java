/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompraCuponera;

import Cuponera.Cuponera;
import Socio.Socio;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;

/**
 *
 * @author rodrigo
 */
@Entity
@Table()
@Cacheable(false)
public class CompraCuponera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float costo;
    private Date fecha;
 
    
    @ManyToOne
    @JoinColumn
    private Cuponera cuponera;
    
    @ManyToOne
    @JoinColumn
    private Socio socio;
    
    
    public int getId(){
        return this.id;
    }
    
    public float getCosto(){
        return this.costo;
    }
    
     public Date getFecha(){
        return this.fecha;
    }
     
    public Cuponera getCuponera(){
        return this.cuponera;
    }
    public Socio getSocio(){
        return this.socio;
    }
    
     public void setId(int id){
        this.id = id;
    }
    
    public void setCosto(float costo){
        this.costo = costo;
    }
    
     public void getFecha(Date fecha){
        this.fecha = fecha;
    }
     
    public void setCuponera(Cuponera cuponera){
        this.cuponera = cuponera;
    }
    
    public void setSocio(Socio socio){
        this.socio = socio;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
  
}

