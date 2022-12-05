/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroSitio;

import EntityManajer.InterfaceEntityManager;
import java.util.List;

/**
 *
 * @author maximilianoolivera
 */
public class RegistroSitioBO implements InterfaceRegistroSitioBO {

    InterfaceRegistroSitioDao regSitioDao = new RegistroSitioDao();

    public RegistroSitioBO() {
               InterfaceEntityManager.getInstance();
    }
    
    @Override
    public void insertar(RegistroSitioDTO registro) {
        regSitioDao.insertar(registro);
    }

    @Override
    public List<RegistroSitioDTO> listarRegistros() {
        return regSitioDao.listarRegistros();
    }

}
