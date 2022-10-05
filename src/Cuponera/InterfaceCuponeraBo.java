/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import Exceptions.ActividadNotFoundException;
import Exceptions.CuponeraAlreadyPurchaseBySocio;
import Socio.exceptions.SocioNotExist;
import java.util.HashMap;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceCuponeraBo {    
    public void agregarCuponera(DtCuponera cuponera);
    public HashMap<Integer, DtCuponera> listarCuponeras();
    public DtCuponera consultarCuponera(int idCuponera);
    public HashMap<Integer, DtCuponera> listarCuponerasVigentes();
    public void comprarCuponera(int socioID,int idCuponera,int idActividad) throws CuponeraAlreadyPurchaseBySocio;
    public HashMap<Integer, DtCuponera> listarCuponerasDisponiblesBySocio(int socioID,int actividadId) throws SocioNotExist, ActividadNotFoundException;
}
