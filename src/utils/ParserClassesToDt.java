/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Actividad.Actividad;
import Actividad.dtos.ActividadDTO;
import Categoria.DtCategoria;
import Clase.DtClase;
import Cuponera.DtCuponera;
import Institucion.DtInstitucion;
import Institucion.Institucion;
import Profesor.dtos.ProfesorDTO;
import Profesor.Profesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import CuponeraXActividad.CuponeraXActividad;
import CuponeraXActividad.DtCuponeraXActividad;
import Cuponera.Cuponera;
import java.io.File;
import javafx.beans.property.SimpleIntegerProperty;
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
        File photo = null;
        if (i.getImage() != null) {
            photo = i.createTempFile();
        }
        SimpleIntegerProperty totalActividadesAceptadas = new SimpleIntegerProperty();
        i.getActividades().forEach((Actividad act) -> {
            if (act.getEstado().equals("Aceptada")) {
                totalActividadesAceptadas.set(totalActividadesAceptadas.get() + 1);
            }
        });
        DtInstitucion dtToReturn = new DtInstitucion(i.getId(), i.getNombre(), i.getDescripcion(), i.getUrl(), getProfesoresDTO(i.getProfesores()) , getActividadDTO(i.getActividades()), photo, i.getImage(), totalActividadesAceptadas.get());
        return dtToReturn;
    }
    
    public ActividadDTO getDtActividad(Actividad actividad) {
        List<DtClase> clases = new ArrayList<>();
        actividad.getClases().forEach((Clase.Clase c) -> {
            String profesorName = c.getActividad().getProfesor().getNombre();
            File file = null;
            if (c.getImage() != null) {
                file = c.createTempFile();
            }
            DtClase cn = new DtClase(c.getId(), c.getNombre(), c.getFecha(),profesorName,null, c.getCapMinima(), c.getCapMaxima(), c.getUrlAcceso(), c.getFechaRegistro(),null,null,null, null, file, null);
            clases.add(cn);
        });
        
        List<DtCuponeraXActividad> cuponerasXAct = new ArrayList<>();
        actividad.getCuponerasXActividad().forEach((CuponeraXActividad cuxa) -> {
            Cuponera cup = cuxa.getCuponera();
            File photo = null;
            if (cup.getImage() != null) {
                photo = cup.createTempFile();
            }
            DtCuponera dtCup = new DtCuponera(cup.getId(), cup.getNombre(), cup.getDescripcion(), cup.getPeriodoVigencia(), cup.getDescuento(),cup.getPrecio(), null, photo);
            DtCuponeraXActividad cu = new DtCuponeraXActividad(cuxa.getId(), cuxa.getCantClases(), dtCup);
            cuponerasXAct.add(cu);
        });
        
        List<DtCategoria> categorias = new ArrayList<>(); // Agregar al DTO creado.
        if(actividad.getCategorias() != null ){
            actividad.getCategorias().forEach((categoria) -> {
                categorias.add(categoria.getDtCategoria());
            });  
 
        }

        ActividadDTO dt = new ActividadDTO(
                actividad.getId(), actividad.getNombre() , actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaRegistro(), null, clases, null, cuponerasXAct, actividad.getImage() != null ? actividad.createTempFile() : null, categorias, actividad.getImage());
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
            if(a.getEstado().equals("Aceptada")){
                acts.add(getDtActividad(a));
            }
        });
        return acts;
    }
    
    public ProfesorDTO getDtProfesor(Profesor prof) {
        ProfesorDTO profe;
        if (prof.getImage() != null ) {
            profe = new ProfesorDTO(
                prof.getId(), prof.getNombre(), prof.getApellido(), prof.getNickname(), prof.getEmail(), prof.getNacimiento(), prof.getDescripcionGeneral(), prof.getBiografia(), prof.getLinkSitioWeb(), null, null, prof.createTempFile(), prof.getSeguidosDt(), prof.getSeguidoresDT(), prof.getImage());
        return profe;
        } else {
            profe = new ProfesorDTO(
                prof.getId(), prof.getNombre(), prof.getApellido(), prof.getNickname(), prof.getEmail(), prof.getNacimiento(), prof.getDescripcionGeneral(), prof.getBiografia(), prof.getLinkSitioWeb(), null, null, null,  prof.getSeguidosDt(), prof.getSeguidoresDT(), prof.getImage());
        return profe;
        }
    }
}
