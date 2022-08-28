/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import Actividad.dtos.ActividadCreateDTO;
import Actividad.dtos.ActividadDTO;
import Actividad.dtos.ActividadDetalleDTO;
import CuponeraXActividad.CuponeraXActividad;
import java.util.HashMap;


/**
 *
 * @author angel
 */
public interface IActividadBO {
    public void crear(ActividadCreateDTO actCreate,int institucionId, int profesorId);
    public HashMap<Integer,ActividadDetalleDTO> consultarById(int id);
    public HashMap<Integer,ActividadDTO> listarByInstitucion(int idInstitucion);
    public HashMap<Integer,ActividadDTO> listarNotInCuponeras(int cuponeraId);
    public void addCupXAct(CuponeraXActividad cupXAct);

}