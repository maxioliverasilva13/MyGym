/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Actividad.Actividad;
import Actividad.dtos.ActividadDTO;
import Clase.DtClase;
import Institucion.DtInstitucion;
import Institucion.Institucion;
import Profesor.dtos.ProfesorDTO;
import Profesor.Profesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author maximilianooliverasilva
 */
public class ParserClassesToDt {
    
    public ParserClassesToDt(){
        
    }
    
    public List<ProfesorDTO> getProfesoresDTO(List<Profesor> profesores) {
        List<ProfesorDTO> profs = new ArrayList<>();
        profesores.forEach((profe) -> {
          profs.add(getDtProfesor(profe));
        });
        return profs;
    }
    
    public List<ActividadDTO> getActividadDTO(List<Actividad> actividades) {
        List<ActividadDTO> acts = new ArrayList<>();
        actividades.forEach((activi) -> {
            acts.add(getDtActividad(activi));
        });
        return acts;
    }
    
    public DtInstitucion getDtInstitucion(Institucion i) {

        DtInstitucion dtToReturn = new DtInstitucion(i.getId(), i.getNombre(), i.getDescripcion(), i.getUrl(), getProfesoresDTO(i.getProfesores()) , getActividadDTO(i.getActividades()));
        return dtToReturn;
    }
    
    public ActividadDTO getDtActividad(Actividad actividad) {
        ActividadDTO dt = new ActividadDTO(
                actividad.getId(), actividad.getNombre() , actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaRegistro(), null, null, null);
        return dt;
    }
    
    public List<DtInstitucion> getInstitucionesDt(List<Institucion> instituciones) {
        List<DtInstitucion> ins = new ArrayList<>();
        instituciones.forEach((Institucion i) -> {
           ins.add(i.getDtInstitucion());
        });
        return ins;
    }
    
    public List<ActividadDTO> getActividadDTOs(Set<Actividad> actividades) {
        List<ActividadDTO> acts = new ArrayList<>();
        actividades.forEach((Actividad a) -> {
           acts.add(getDtActividad(a));
        });
        return acts;
    }
    
    public ProfesorDTO getDtProfesor(Profesor prof) {
        ProfesorDTO profe;
        profe = new ProfesorDTO(
                prof.getId(), prof.getNombre(), prof.getApellido(), prof.getNickname(), prof.getEmail(), prof.getNacimiento(), prof.getDescripcionGeneral(), prof.getBiografia(), prof.getLinkSitioWeb(), null, null);
        return profe;
    }
}
