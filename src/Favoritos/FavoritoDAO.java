/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Favoritos;

import Actividad.ActividadDao;
import EntityManajer.InterfaceEntityManager;
import Socio.SocioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import Actividad.Actividad;
import Socio.Socio;

/**
 *
 * @author maximilianoolivera
 */
public class FavoritoDAO implements InterfaceFavoritoDAO {

    EntityManager em = InterfaceEntityManager.getInstance();
    ActividadDao actDao = new ActividadDao();
    SocioDAO socDao = new SocioDAO();
    
    public FavoritoDAO() {
               InterfaceEntityManager.getInstance();
    }
    
    @Override
    public boolean toggleFavoritoActividad(int idActividad, int idSocio) {
        try {
            List<Favorito> favoritos = em.createNativeQuery("select * from favorito fav where fav.SOCIOFAV_ID=" + idSocio + " AND fav.ACTIVIDADFAV_ID= " + idActividad, Favorito.class).getResultList();
            if (favoritos.size() > 0) {
                System.out.println("si1");
                favoritos.forEach((Favorito f) -> {
                    em.getTransaction().begin();
                    em.remove(f);
                    em.getTransaction().commit();
                });
                return false;
            } else {
                                System.out.println("si2");
                Favorito fav = new Favorito();
                Actividad act = actDao.getById(idActividad);
                Socio soc = socDao.getById(idSocio);
                fav.setActividad(act);
                fav.setSocioFav(soc);
                em.getTransaction().begin();
                em.persist(fav);
                em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Toggle Actividad Favorita");
        }
        return false;
    }

}
