/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import Actividad.dtos.ActividadCreateDTO;
import Clase.Clase;
import CuponeraXActividad.CuponeraXActividad;
import Institucion.Institucion;
import Profesor.Profesor;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author angel
 */
public interface IActividadDao {
    public void create(ActividadCreateDTO act ,Profesor profesor,Institucion institucion);
    public Actividad getById(ActividadCreateDTO act);
    public List<Actividad> listAll();
  
   
}