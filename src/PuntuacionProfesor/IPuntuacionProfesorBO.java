/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PuntuacionProfesor;

import Exceptions.RegistroNotFoundException;
import Exceptions.SocioNotFoundException;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;

/**
 *
 * @author rodrigo
 */
public interface IPuntuacionProfesorBO {
    DtPuntuacionProfesor create(int puntuacion,int socioId,int registroId) throws SocioNotFoundException,RegistroNotFoundException,Exception;
    
}
