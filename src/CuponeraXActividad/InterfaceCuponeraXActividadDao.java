/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

import Actividad.Actividad;
import Cuponera.Cuponera;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceCuponeraXActividadDao {
    public void insertar(int idActividad, int idCuponera, DtCuponeraXActividad cupXA);
    public CuponeraXActividad existe(int idCuXAc);
    public int getCantClass(Cuponera cup , Actividad act);

}
