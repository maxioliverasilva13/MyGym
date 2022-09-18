/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad.dtos;

import java.io.File;
import java.util.Date;

/**
 *
 * @author angel
 */
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
    
    
    public ActividadCreateDTO(int institucion_id,int profesor_id, float costo, String nombre, String descripcion, Date fecha_registro, int duracion,String estado){
        this.institucion_id = institucion_id;
        this.profesor_id = profesor_id;
        this.costo = costo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.duracion = duracion;
        this.estado = estado;
    }
    
    public ActividadCreateDTO(int institucion_id,int profesor_id, float costo, String nombre, String descripcion, Date fecha_registro, int duracion, File file){
        this.institucion_id = institucion_id;
        this.profesor_id = profesor_id;
        this.costo = costo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.duracion = duracion;
        this.image = file;
    }

    public File getImage() {
        return image;
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
