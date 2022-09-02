/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygymapp;

import Actividad.ActividadBO;
import Actividad.IActividadBO;
import Actividad.dtos.ActividadCreateDTO;
import EntityManajer.InterfaceEntityManager;
import Institucion.InstitucionBO;
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
import Actividad.Actividad;
import Actividad.dtos.ActividadDetalleDTO;
import Clase.ClaseBO;
import Clase.DtClase;
import CuponeraXActividad.CuponeraXActividadBo;
import CuponeraXActividad.CuponeraXActividadDao;
import Registro.DtRegistro;
import Registro.RegistroBO;
import Registro.RegistroDao;
import CuponeraXActividad.DtCuponeraXActividad;
import Exceptions.CuponeraNotFoundException;
import Exceptions.InstitucionNotFoundException;
import Institucion.DtInstitucion;
import Socio.ISocioBO;
import Socio.SocioBO;
import Socio.dtos.SocioDTO;
import Socio.exceptions.SocioNotExist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import Institucion.InterfaceInstitucionBO;
import Usuario.exceptions.UserNotExist;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maximilianooliverasilva
 */
public class MyGymApp {

    public static void main(String[] args)  {
        Dashboard ds = new Dashboard();
        ds.setVisible(true);
    }
}