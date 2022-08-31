/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import Actividad.dtos.ActividadCreateDTO;
import Actividad.dtos.ActividadDTO;
import Actividad.dtos.ActividadDetalleDTO;
import CuponeraXActividad.CuponeraXActividad;
import Exceptions.CuponeraNotFoundException;
import Exceptions.InstitucionNotFoundException;
import java.util.HashMap;
import mygym.logica.usuario.dataTypes.DtActividad;


/**
 *
 * @author angel
 */
public interface IActividadBO {
    public void crear(ActividadCreateDTO actCreate,int institucionId, int profesorId);
    public HashMap<Integer,ActividadDetalleDTO> consultarById(int id);
    public HashMap<Integer,ActividadDTO> listarByInstitucion(int idInstitucion);
    public HashMap<Integer,ActividadDTO> listarByInstitucionNotInCuponeras(int institucionId, int cuponeraId) throws InstitucionNotFoundException,CuponeraNotFoundException;
    public void addCupXAct(CuponeraXActividad cupXAct);
    public HashMap<Integer, ActividadDTO> listarActividades();
    
}
