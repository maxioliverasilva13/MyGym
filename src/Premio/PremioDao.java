/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Premio;

import Clase.Clase;
import EntityManajer.InterfaceEntityManager;
import Premio.InterfacePremioDao;
import Clase.ClaseDao;
import Exceptions.ClaseNotFoundException;
import Exceptions.PremioNotFoundException;
import Exceptions.SocioAlreadyAreInClass;
import javax.persistence.EntityManager;
import Premio.Premio;
import Premio.dtos.PremioDTO;
import Usuario.dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Registro.Registro;
import Socio.dtos.SocioDTO;
import java.util.Random;

/**
 *
 * @author maximilianoolivera
 */
public class PremioDao implements InterfacePremioDao {

    EntityManager em = InterfaceEntityManager.getInstance();
    ClaseDao claseDao = new ClaseDao();

    public void insertarPremio(int idClase, String nombre, int cantidadSorteado) {
        try {
            Clase clase = claseDao.existe(idClase);
            Premio premio = new Premio();
            premio.setDescripcion(nombre);
            premio.setCantidadSorteados(cantidadSorteado);
            premio.setFechaCreacion(new Date());
            premio.setFueSorteado(false);
            premio.setClase(clase);
            em.getTransaction().begin();
            em.persist(premio);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("InsertarPremio-PremioDao");
            System.out.println(e.getMessage());
        }
    }

    public Premio existe(int id) throws PremioNotFoundException {
        Premio premio = em.find(Premio.class, id);
        if (premio == null) {
            throw new PremioNotFoundException("El premio no existe");
        }
        return premio;
    }

    @Override
    public List<SocioDTO> realizarSorteo(int idPremio) {
        try {
            Premio premio = existe(idPremio);
            if (premio.getClase().getRegistros().size() == 0) {
                throw new PremioNotFoundException("No puedes sortear si aun no tienens ningun alumno");
            }
            List<SocioDTO> usuarios = new ArrayList<>();
            List<SocioDTO> usuariosSorteados = new ArrayList<>();

            Clase clase = premio.getClase();
            if (clase == null) {
                throw new ClaseNotFoundException("Clase no encontrada");
            }
            Random rand = new Random();

            clase.getRegistros().forEach((Registro reg) -> {
                usuarios.add(reg.getSocio().getDtSocio());
            });

            int cantidadSorteados = premio.getCantidadSorteados() >= usuarios.size() ? usuarios.size() : premio.getCantidadSorteados();
            for (int i = 0; i < cantidadSorteados; i++) {
                int randomIndex = rand.nextInt(usuarios.size());
                SocioDTO randomElement = usuarios.get(randomIndex);
                usuariosSorteados.add(usuarios.get(randomIndex));
                usuarios.remove(randomIndex);
            }
            System.out.println("xd1");
            usuariosSorteados.forEach((SocioDTO socio) -> {
                List<Registro> lista = em.createNativeQuery("select * from registro r where r.CLASE_ID=" + premio.getClase().getId() + " and r.SOCIO_id=" + socio.getId(), Registro.class).getResultList();
                System.out.println(lista);

                if (lista.size() > 0) {
                    Registro r = lista.get(0);
                    em.getTransaction().begin();
                    r.agregarPremio(premio);
                    premio.agregarRegistro(r);
                    premio.setFueSorteado(true);
                    em.getTransaction().commit();
                    System.out.println("sii");
                }

            });

            return usuariosSorteados;

        } catch (PremioNotFoundException ex) {
            System.out.println("RealizarSorteo - PrmeioDao");
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<PremioDTO> premiosOfUser(int idSocio) {
        List<PremioDTO> premiosToReturn = new ArrayList<>();
        List<Premio> lista = em.createNativeQuery("select prem.ID, prem.CANTIDADSORTEADOS, prem.DESCRIPCION, prem.FECHACREACION, prem.FUESORTEADO, prem.CLASEOFPREMIO_ID from registro_premio rp inner join premio prem on prem.ID = rp.premios_ID where EXISTS (select * from registro r where r.id = rp.registros_ID and r.SOCIO_ID = " + idSocio + " );", Premio.class).getResultList();
        if (lista.size() > 0) {
            lista.forEach((Premio premio) -> {
                premiosToReturn.add(premio.getDtPremio());
            });
        }
        return premiosToReturn;
    }

}
