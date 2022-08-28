/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygymapp;

import Clase.ClaseBO;
import Clase.DtClase;
import Cuponera.CuponeraBo;
import Cuponera.DtCuponera;
import EntityManajer.InterfaceEntityManager;
import Institucion.DtInstitucion;
import ParseDate.ParseDate;
import Registro.DtRegistro;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.EntityManager;
import mygym.logica.usuario.dataTypes.DtActividad;
import static mygym.presentacion.pages.Actividades.actividadesSistema;
import mygym.presentacion.pages.Dashboard;
import Registro.DtRegistro;
import Institucion.InstitucionBO;
import Registro.InterfaceRegistroBO;
import Registro.RegistroBO;
import CuponeraXActividad.CuponeraXActividadBo;
import CuponeraXActividad.DtCuponeraXActividad;

/**
 *
 * @author maximilianooliverasilva
 */
public class MyGymApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        ClaseBO clbo = new ClaseBO();
        InstitucionBO insbo = new InstitucionBO();
        RegistroBO rebo = new RegistroBO();
        CuponeraBo cubo = new CuponeraBo();
        ParseDate ps = new ParseDate();
        CuponeraXActividadBo cupXBo = new CuponeraXActividadBo();
        
        // DtClase cl = new DtClase();
        // cl.setCapMaxima(200);
        // cl.setCapMinima(200);
        // cl.setFecha(ps.parseDate("2022-01-01"));
        // cl.setNombre("Clase Natacion 2");
        // cl.setUrlAcceso("Esto es una url 22");
        // cl.setFechaRegistro(ps.parseDate("2022-01-01"));
        // clbo.insertarUsuario(2, cl);
        
        //HashMap<Integer,DtClase> clasesById = clbo.listarClasesByAct(1);
        //clasesById.forEach((key, value) -> {
        //     value.getRegistros().forEach((va) -> {
        //         System.out.println(va.getSocioName());
        //     });
        //});
        
        //DtRegistro dt = new DtRegistro();
        //dt.setId(1);
        //dt.setCosto(12);
        // clbo.agregarRegistro(301, dt);
        
        //Dashboard ds = new Dashboard();
        //ds.setVisible(true);
        
        //DtInstitucion inst = new DtInstitucion();
        //inst.setDescripcion("La mejor institucion");
        //inst.setNombre("UA");
        //inst.setUrl("www.inst.com");
        
        //insbo.agregarInstitucion(inst);
        
        //DtInstitucion ins = insbo.existeInstitucion(551);
        //System.out.println(ins.getNombre());
        
        // insbo.agregarProfesor(1, 551);
        // insbo.agregarActividad(1, 1);
        
        // Insertar Registro
        //DtRegistro reg = new DtRegistro();
        //reg.setFecha(ps.parseDate("2022-01-01"));
        //reg.setCosto(12);
        
        //rebo.agregarRegistro(1, 1, reg);
        
        //DtClase clase = clbo.consultarClase(1);
        //System.out.println(clase.getRegistros().size());
        //clase.getRegistros().forEach((item) -> {
        //    System.out.println(item.getClaseName());
        //});
        
        //DtCuponera cup = new DtCuponera();
        //cup.setDescripcion("Dsc1");
        //cup.setDescuento(12);
        //cup.setNombre("Lo mejor");
        //cup.setPeriodoVigencia(ps.parseDate("2022-01-01"));
        
        // cubo.agregarCuponera(cup);
        
        //cubo.listarCuponeras().forEach((key, value) -> {
        //    System.out.println(value.getNombre());
        //});
        // System.out.println(cubo.consultarCuponera(1).getNombre());
        
        DtCuponeraXActividad cupXact = new DtCuponeraXActividad(25);
        cupXBo.agregarCupXAct(1, 151, cupXact);
        
    }
    
}
