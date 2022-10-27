/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

import Actividad.Actividad;
import Actividad.ActividadBO;
import Actividad.ActividadDao;
import Actividad.IActividadBO;
import Actividad.IActividadDao;
import Cuponera.Cuponera;
import Cuponera.CuponeraBo;
import Cuponera.CuponeraDao;
import Cuponera.InterfaceCuponeraBo;
import Cuponera.InterfaceCuponeraDao;
import Exceptions.ActividadNotFoundException;
import Exceptions.CuponeraNotFoundException;

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

    @Override
    public int getCantClass(Actividad idActividad, Cuponera idCuponera) {
        InterfaceCuponeraDao  cupDao = new CuponeraDao();
        Cuponera cup = cupDao.existe(idCuponera.getId());
        if(cup == null){
            throw new CuponeraNotFoundException("La cuponera no existe");
        }
        IActividadDao actBo = new ActividadDao();
        Actividad act = actBo.getById(idActividad.getId());
        if(act  == null){
            throw new ActividadNotFoundException("Actividad no existe");
        }
        return this.cupxactdao.getCantClass(cup, act);
    }
    
     @Override
    public CuponeraXActividad get(int idActividad, int idCuponera) {
        InterfaceCuponeraDao  cupDao = new CuponeraDao();
        Cuponera cup = cupDao.existe(idCuponera);
        if(cup == null){
            throw new CuponeraNotFoundException("La cuponera no existe");
        }
        IActividadDao actBo = new ActividadDao();
        Actividad act = actBo.getById(idActividad);
        if(act  == null){
            throw new ActividadNotFoundException("Actividad no existe");
        }
        CuponeraXActividad res = this.cupxactdao.get(cup,act);
        return res;
    }
    
    
}
