/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompraCuponera;

import EntityManajer.InterfaceEntityManager;
import Exceptions.CompraCuponeraNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rodrigo
 */
public class CompraCuponeraDao implements ICompraCuponeraDao{
    EntityManager em = InterfaceEntityManager.getInstance();

    @Override
    public CompraCuponera getByCuponeraAndSocio(int cuponeraId, int socioID)  throws CompraCuponeraNotFoundException{
        List<CompraCuponera> cps = this.em.createNativeQuery("SELECT * FROM CompraCuponera WHERE CUPONERA_ID="+cuponeraId+" AND SOCIO_ID="+socioID+";",CompraCuponera.class).getResultList();
        if(cps.size() <= 0)  {
            throw new CompraCuponeraNotFoundException("No existe una compra de este socio a la cuponera");
        }
        return cps.get(0);
    }
    
}
