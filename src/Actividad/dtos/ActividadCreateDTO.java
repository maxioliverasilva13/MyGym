/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad.dtos;

import Categoria.DtCategoria;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author angel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ActividadCreateDTO {
    private int institucion_id;
    private float costo;
    private String nombre;
    private String descripcion;
    private int duracion;
    private Date fecha_registro;
    private int profesor_id;
    File image;
    private String estado;
    private List<DtCategoria> categorias = new ArrayList<>();
    
    public ActividadCreateDTO() {
        
    }
    
    public ActividadCreateDTO(int institucion_id,int profesor_id, float costo, String nombre, String descripcion, Date fecha_registro, int duracion, File file, List<DtCategoria> catsInThisActividad, String estado){
        this.institucion_id = institucion_id;
        this.profesor_id = profesor_id;
        this.costo = costo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.duracion = duracion;
        this.image = file;
        this.categorias = catsInThisActividad;
        this.estado = estado;
    }

    public File getImage() {
        return image;
    }
    
    public List<DtCategoria> getCategorias() {
        return categorias;
    }
    
     public int getInstitucionId(){
         return this.institucion_id;
     }
     
     public float getCosto(){
         return this.costo;
     }
     public String getNombre(){
         return this.nombre;
     }     
     public String getDescripcion(){
         return this.descripcion;
     }
    
     public int getDuracion(){
         return this.duracion;
     }
     
     public Date getFechaRegistro(){
        return this.fecha_registro;
     }
    
     public int getProfesorId(){
        return this.profesor_id;   
     }
     
     public String getEstado(){
        return this.estado;
     }
    
}
