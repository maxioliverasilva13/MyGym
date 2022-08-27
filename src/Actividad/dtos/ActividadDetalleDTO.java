/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad.dtos;

import java.util.Date;

/**
 *
 * @author angel
 */
public class ActividadDetalleDTO {
    private int id;
    private int institucion_id;
    private double costo;
    private String descripcion;
    private int duracion;
    private Date fecha_registro;
    private int profesor_id;
    //private Hasmap<int,CuponeraDto> cuponeras;
    //private Hasmap<int,ClaseDto> clasess;

   
    
    public ActividadDetalleDTO(int id,int institucion_id,int profesor_id, double costo, String descripcion, Date fecha_registro, int duracion){
        this.id = id;
        this.institucion_id = institucion_id;
        this.profesor_id = profesor_id;
        this.costo = costo;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.duracion = duracion;
    }
    
    public int getId(){
        return this.id;
    }
    
     public int getInstitucionId(){
         return this.institucion_id;
     }
     public double getCosto(){
         return this.costo;
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
    
}
