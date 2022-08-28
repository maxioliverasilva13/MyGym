/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

/**
 *
 * @author maximilianooliverasilva
 */
public class CuponeraXActividadBo implements InterfaceCuponeraXActividadBo {
    CuponeraXActividadDao cupxactdao = new CuponeraXActividadDao();
    
    @Override
    public void agregarCupXAct(int idActividad, int idCuponera, DtCuponeraXActividad cupXact){
        cupxactdao.insertar(idActividad, idCuponera, cupXact);
    }
}
