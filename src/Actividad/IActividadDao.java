/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import Actividad.dtos.ActividadCreateDTO;
import Categoria.Categoria;
import Categoria.DtCategoria;
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
    public void createWithCategorias(ActividadCreateDTO act ,Profesor profesor,Institucion institucion, List<DtCategoria> categorias);
    public Actividad getById(int idAct);
    public void agregarCategoria(int idActividad, Categoria cat);
    public List<Actividad> listAll();
    public void agregarCupXActividad(int idActividad, CuponeraXActividad idCxA );
    public void agergarClase(int idActividad, Clase clase);
    public Collection<Actividad> listarActividadesByInstitucionNotIntCup(int institucionId, int cuponeraId,String status);  // lista las actividades pertenecientes a esa actividad que no tienen esa cuponera
    public Collection<Actividad> listarActividades(int idInstitucion,String status);
    public List<Actividad> listarAllActividadesPendientes();
    public void cambiarEstado(Actividad act,String newStatus);
    public List<Actividad> getAllActividadesWithLimitAndAccepted(int limite);
    public int getActividadesAceptadasSize();
    public List<Actividad> listarActividadesByProfesor(int profID);
}
