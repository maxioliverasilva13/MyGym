/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PuntuacionProfesor;

import Profesor.Profesor;
import Registro.Registro;
import Socio.Socio;

/**
 *
 * @author rodrigo
 */
public interface IPuntuacionProfesorDAO {
    PuntuacionProfesor create(Registro registro, int puntuacion);
    boolean existe(int id);
    boolean existeByRegistro(Registro registro);
}
