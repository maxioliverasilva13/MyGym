/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroBO implements InterfaceRegistroBO {
    RegistroDao registrodao = new RegistroDao();
    
    @Override
    public void agregarRegistro(int idSocio, int idClase, DtRegistro registro){
        registrodao.insertar(idSocio, idClase, registro);
    }

}
