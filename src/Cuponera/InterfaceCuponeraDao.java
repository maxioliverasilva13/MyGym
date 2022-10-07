/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import CuponeraXActividad.DtCuponeraXActividad;
import java.util.List;
import java.util.Set;
import CuponeraXActividad.CuponeraXActividad;
import Socio.Socio;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceCuponeraDao {
    public void insertar(DtCuponera cuponera);
    public List<Cuponera> listar();
    public Cuponera existe(int idCup);
    public void agregarCupXActividad(int idCuponera, CuponeraXActividad cupXA);
    public List<Cuponera> listarVigentes();
    public void comprarCuponera(Socio socio,Cuponera cuponera,int cantClases);
    public List<Cuponera> listarDisponiblesBySocioAndActividad(int socioID,int actId);
}
