package PuntuacionProfesor;

import Clase.Clase;
import Profesor.Profesor;
import Registro.Registro;
import Socio.Socio;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;


@Entity
@Table
public class PuntuacionProfesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int puntuacion;
    private Date fecha;
 
    
    
    @OneToOne
    @JoinColumn
    private  Registro registro;
    
    
    public int getId(){
        return this.id;
    }
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public Date getFecha(){
        return this.fecha;
    }
  
   
 
    public void setId(int id){
        this.id = id;
    }
    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
  
    public  void setRegistro(Registro registro){
        this.registro = registro;
    }
    
    public  Registro getRegistro(){
        return this.registro;
    }
    
    
    public DtPuntuacionProfesor getDt(){
        DtPuntuacionProfesor res = new DtPuntuacionProfesor(this.id,this.fecha,this.puntuacion);
        return res;
    }
    
    
    
    

}
