/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import CuponeraXActividad.DtCuponeraXActividad;
import java.util.List;
import java.util.Set;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceCuponeraDao {
    public void insertar(DtCuponera cuponera);
    public List<Cuponera> listar();
    public Cuponera existe(int idCup);
    public void agregarCupXActividad(int idCuponera, int idCupXActvidad);
}
