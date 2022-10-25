/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

import Actividad.dtos.ActividadDTO;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceCuponeraXActividadBo {
    public void agregarCupXAct(int idActividad, int idCuponera, DtCuponeraXActividad cupXact);
    public int getCantClass(Actividad.Actividad idActividad, Cuponera.Cuponera idCuponera);
}
