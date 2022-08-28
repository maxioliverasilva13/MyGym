/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceRegistroDao {
    public void insertar(int idSocio, int idClase, DtRegistro registro);
    public Registro existe(int idRegistro);
}
