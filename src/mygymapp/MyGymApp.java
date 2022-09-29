/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygymapp;

import Actividad.ActividadBO;
import Actividad.IActividadBO;
import Actividad.dtos.ActividadCreateDTO;
import EntityManajer.InterfaceEntityManager;
import Usuario.UsuarioDAO;
import javax.persistence.EntityManager;
import mygym.presentacion.pages.Dashboard;

/**
 *
 * @author maximilianooliverasilva
 */
public class MyGymApp {

    public static void main(String[] args)  {
        EntityManager em = InterfaceEntityManager.getInstance();
        Dashboard ds = new Dashboard();
        ds.setVisible(true);
        
        IActividadBO actBo = new ActividadBO();
       // int institucion_id,int profesor_id, float costo, String nombre, String descripcion, Date fecha_registro, int duracion
       // ActividadCreateDTO actDTO = new ActividadCreateDTO(null,null,);
     //   actBo.crear(actCreate, 0, 0);
    }
}