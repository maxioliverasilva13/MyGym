package CompraCuponera;

import Exceptions.CompraCuponeraNotFoundException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rodrigo
 */
public class CompraCuponeraBo implements ICompraCuponeraBo{

    @Override
    public CompraCuponera getByCuponeraAndSocio(int cuponeraId, int socioID) throws CompraCuponeraNotFoundException {
        ICompraCuponeraDao compCup = new CompraCuponeraDao();
        return compCup.getByCuponeraAndSocio(cuponeraId, socioID);
      
    }
    
}
