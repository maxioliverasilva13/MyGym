/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import Actividad.dtos.ActividadCreateDTO;
import Actividad.dtos.ActividadDTO;
import Actividad.dtos.ActividadDetalleDTO;
import Categoria.DtCategoria;
import CuponeraXActividad.CuponeraXActividad;
import Exceptions.ActividadNotFoundException;
import Exceptions.CuponeraNotFoundException;
import Exceptions.InstitucionNotFoundException;
import java.util.HashMap;
import java.util.List;
import mygym.logica.usuario.dataTypes.DtActividad;


/**
 *
 * @author angel
 */
public interface IActividadBO {
    public void crear(ActividadCreateDTO actCreate,int institucionId, int profesorId);
    public ActividadDTO consultarById(int id);
    public HashMap<Integer,ActividadDTO> listarByInstitucion(int idInstitucion,String status);
    public HashMap<Integer,ActividadDTO> listarByInstitucionNotInCuponeras(int institucionId, int cuponeraId,String status) throws InstitucionNotFoundException,CuponeraNotFoundException;
    public void addCupXAct(CuponeraXActividad cupXAct);
    public HashMap<Integer, ActividadDTO> listarActividades(int idInstitucion,String status);
    public HashMap<Integer, ActividadDTO> listarActividadesByCategoria(List<String> cat, String estado);
    public HashMap<Integer, ActividadDTO> listarAllActividadesPendientes();
    public void cambiarEstado(int idActividad, String newStatus) throws ActividadNotFoundException ;
    public HashMap<Integer, ActividadDTO> getActividadesWithLimitAndAccepted(int limite);
    public int getActividadesAceptadasSize();
    public HashMap<Integer, ActividadDTO> listarActividadesByProfesor(int idProf);
    public void crearWithCategorias(ActividadCreateDTO actCreate, int institucionId, int profesorId, List<DtCategoria> categorias);
}
