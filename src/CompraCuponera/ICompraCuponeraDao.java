/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompraCuponera;

import Exceptions.CompraCuponeraNotFoundException;

/**
 *
 * @author rodrigo
 */
public interface ICompraCuponeraDao {
     public CompraCuponera getByCuponeraAndSocio(int cuponeraId, int socioID) throws CompraCuponeraNotFoundException;
}
