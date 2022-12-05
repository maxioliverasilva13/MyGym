/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroSitio;

import Clase.ClaseDao;
import Clase.Clase;
import CompraCuponera.CompraCuponera;
import CompraCuponera.CompraCuponeraBo;
import CompraCuponera.ICompraCuponeraBo;
import Cuponera.Cuponera;
import CuponeraXActividad.CuponeraXActividad;
import CuponeraXActividad.CuponeraXActividadBo;
import CuponeraXActividad.InterfaceCuponeraXActividadBo;
import Socio.Socio;
import EntityManajer.InterfaceEntityManager;
import Exceptions.ClaseNotFoundException;
import Exceptions.ClassHasMaxOfReg;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.CuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.RegistroNotFoundException;
import Exceptions.SocioAlreadyAreInClass;
import Exceptions.SocioNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Socio.SocioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroSitioDao implements InterfaceRegistroSitioDao {

    EntityManager em = InterfaceEntityManager.getInstance();

    @Override
    public void insertar(RegistroSitioDTO registro) {
        RegistroSitio reg = new RegistroSitio();
        reg.setBrowser(registro.getBrowser());
        reg.setIp(registro.getIp());
        reg.setSo(registro.getSo());
        reg.setUrl(registro.getUrl());
        em.persist(reg);
    }

    public List<RegistroSitioDTO> listarRegistros() {
        List<RegistroSitio> registrosAlSitio = em.createNativeQuery("select * from registrositio", RegistroSitio.class).getResultList();
        List<RegistroSitioDTO> registros = new ArrayList<>();
        registrosAlSitio.forEach((RegistroSitio res) -> {
            registros.add(res.getRegistroSitioDTO());
        });
        return registros;
    }

}
