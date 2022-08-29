/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import java.util.HashMap;
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

}
