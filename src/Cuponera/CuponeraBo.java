/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import Actividad.ActividadBO;
import Actividad.ActividadDao;
import Actividad.IActividadBO;
import Actividad.IActividadDao;
import CompraCuponera.CompraCuponera;
import CuponeraXActividad.CuponeraXActividad;
import CuponeraXActividad.CuponeraXActividadBo;
import CuponeraXActividad.InterfaceCuponeraXActividadBo;
import Exceptions.ActividadNotFoundException;
import Exceptions.CuponeraAlreadyPurchaseBySocio;
import Exceptions.CuponeraNotFoundException;
import Socio.ISocioBO;
import Socio.ISocioDAO;
import Socio.Socio;
import Socio.SocioBO;
import Socio.SocioDAO;
import Socio.exceptions.SocioNotExist;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public class CuponeraBo implements InterfaceCuponeraBo {
    CuponeraDao cuponeradao = new CuponeraDao();

    @Override
    public void agregarCuponera(DtCuponera cuponera){
        cuponeradao.insertar(cuponera);
    }
    
    @Override
    public HashMap<Integer, DtCuponera> listarCuponeras(){
        HashMap<Integer, DtCuponera> cuponeras = new HashMap<>();
        cuponeradao.listar().forEach((cupone) -> {
            cuponeras.put(cupone.getId(), cupone.getDtCuponera());
        });
        return cuponeras;
    }
    
    @Override
    public DtCuponera consultarCuponera(int idCuponera){
        Cuponera cup = cuponeradao.existe(idCuponera);
        if (cup == null) {
            return null;
        }
        return cup.getDtCuponera();
    }

    @Override
    public HashMap<Integer, DtCuponera> listarCuponerasVigentes() {
        HashMap<Integer, DtCuponera> res = new HashMap<Integer, DtCuponera>();
        cuponeradao.listarVigentes().forEach(cuponera ->{
            res.put(cuponera.getId(), cuponera.getDtCuponera());
        });
        return res;
    }
    
    
    @Override
    public void comprarCuponera(int socioID,int IdCuponera,int idActividad) throws CuponeraAlreadyPurchaseBySocio {
        ISocioDAO socioDao = new SocioDAO();
        Socio socioFind = socioDao.getById(socioID);
        if(socioFind == null) {
            throw new SocioNotExist("El socio no existe");
        }       
        Cuponera cuponeraFind = this.cuponeradao.existe(IdCuponera);
        if(cuponeraFind == null){
            throw new CuponeraNotFoundException("La cuponera no existe");
        }
       
        Collection<CompraCuponera> comprasCuponerasBySocio = socioFind.getCuponerasCompradas();
        Iterator<CompraCuponera> it = comprasCuponerasBySocio.iterator();
        CompraCuponera curr;
        boolean alreadyPurchase = false;
        while(it.hasNext()){
           curr  = it.next();
           if(curr.getCuponera().getId() == IdCuponera){
               alreadyPurchase = true;
               break;  
           }
        }
        if(alreadyPurchase){
           throw new CuponeraAlreadyPurchaseBySocio("El socio ya tiene esta cuponera"); 
        }
        InterfaceCuponeraXActividadBo cupxActBo = new CuponeraXActividadBo();
        int cantClases =  cupxActBo.getCantClass(idActividad, IdCuponera);
        cuponeradao.comprarCuponera(socioFind, cuponeraFind,cantClases);
        
    }
    
    public HashMap<Integer, DtCuponera> listarCuponerasDisponiblesBySocio(int socioID,int actividadId) throws SocioNotExist,ActividadNotFoundException {
      
        ISocioBO socioBo = new SocioBO();
        if (socioBo.consultarSocio(socioID) == null){
            throw new SocioNotExist("El socio no existe");   
        }
        
        IActividadDao actDao = new ActividadDao();
        if(actDao.getById(actividadId) == null){
            throw new ActividadNotFoundException("La actividad no existe");
        }
        
        HashMap<Integer, DtCuponera> res = new HashMap<Integer, DtCuponera>();
        this.cuponeradao.listarDisponiblesBySocioAndActividad(socioID,actividadId).forEach(cup -> {
            res.put(cup.getId(), cup.getDtCuponera());
        });
       
        return res;
    }

    public HashMap<Integer, DtCuponera> listarCuponerasBySocio(int socioID) throws SocioNotExist {
      
        ISocioBO socioBo = new SocioBO();
        if (socioBo.consultarSocio(socioID) == null){
            throw new SocioNotExist("El socio no existe");   
        }
               
        HashMap<Integer, DtCuponera> res = new HashMap<Integer, DtCuponera>();
        this.cuponeradao.listarDisponiblesBySocio(socioID).forEach(cup -> {
            res.put(cup.getId(), cup.getDtCuponera());
        });
       
        return res;
    }
}
