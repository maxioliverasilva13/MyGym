/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CompraCuponera;

import Exceptions.CompraCuponeraNotFoundException;

/**
 *
 * @author rodrigo
 */
public interface ICompraCuponeraBo {
    public CompraCuponera getByCuponeraAndSocio(int cuponeraId, int socioID) throws CompraCuponeraNotFoundException;
}
