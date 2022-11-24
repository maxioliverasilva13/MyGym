/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Actividad.Actividad;
import Exceptions.ClaseNotFoundException;
import Exceptions.ProfesorNoDictaClaseException;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Profesor.exceptions.ProfesorNotExist;
import java.util.List;
import mygym.logica.usuario.dataTypes.ProfesorPuntuacionesDTO;

/**
 *
 * @author angel
 */
public interface IProfesorBO  {
    public ProfesorDTO getProfesorById(int id) throws ProfesorNotExist;
    public void editProfesorById(int id,ProfesorEditDTO profEdit);
    public boolean existeById(int id);
    public void agregarActividad(Actividad act);
    public DtInstitucion getInstitucion(int idProf);
    public ProfesorPuntuacionesDTO getValoracionesGenerales(int idProf);
    public double getValoracionByClass(int idClass) ; 
    public int getCantValoracionByClass(int idClass);
   
}
