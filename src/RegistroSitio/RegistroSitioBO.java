/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroSitio;

import java.util.List;

/**
 *
 * @author maximilianoolivera
 */
public class RegistroSitioBO implements InterfaceRegistroSitioBO {

    InterfaceRegistroSitioDao regSitioDao = new RegistroSitioDao();

    @Override
    public void insertar(RegistroSitioDTO registro) {
        regSitioDao.insertar(registro);
    }

    @Override
    public List<RegistroSitioDTO> listarRegistros() {
        return regSitioDao.listarRegistros();
    }

}
