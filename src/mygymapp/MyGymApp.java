/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygymapp;

import Actividad.ActividadBO;
import Actividad.IActividadBO;
import Actividad.dtos.ActividadCreateDTO;
import EntityManajer.InterfaceEntityManager;
import Profesor.IProfesorBO;
import Profesor.Profesor;
import Profesor.ProfesorBO;
import Profesor.ProfesorDao;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.exceptions.ProfesorNotExist;
import Socio.dtos.SocioCreateDTO;
import Usuario.IUsuarioBO;
import Usuario.UsuarioBO;
import Usuario.exceptions.UserAlreadyEmailExist;
import java.util.Date;
import javax.persistence.EntityManager;
import mygym.presentacion.pages.Dashboard;

/**
 *
 * @author maximilianooliverasilva
 */
public class MyGymApp {





    public static void main(String[] args)  {
        EntityManager inter = InterfaceEntityManager.getInstance();
        Dashboard ds = new Dashboard();
        ds.setVisible(true);

        IProfesorBO profBO = new ProfesorBO();

        try{
           ProfesorDTO pro = profBO.getProfesorById(2);
           System.out.println(pro.getId());
        }catch(ProfesorNotExist p){
            System.out.println(p.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }




    }

}