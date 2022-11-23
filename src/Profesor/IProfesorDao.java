/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Clase.Clase;
import Profesor.dtos.ProfesorEditDTO;
import PuntuacionProfesor.PuntuacionProfesor;
import java.util.List;
import mygym.logica.usuario.dataTypes.ProfesorPuntuacionesDTO;
/**
 *
 * @author angel
 */
public interface IProfesorDao {
   
    public void editById(int id, ProfesorEditDTO editProf);
    public Profesor getByNickname(String nickname);
    public Profesor getById(int id);
    public List<PuntuacionProfesor> getPuntuacionesProfesor(Profesor prof);
    public List<PuntuacionProfesor> getPuntuacionesProfesorByClass(Clase clase);
 
}
