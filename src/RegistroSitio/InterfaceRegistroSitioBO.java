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
public interface InterfaceRegistroSitioBO {
    public void insertar(RegistroSitioDTO registro);
    public List<RegistroSitioDTO> listarRegistros();
}
