package Registro;

import Clase.DtClase;
import Socio.dtos.SocioDTO;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maximilianooliverasilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtRegistro {

    private int id;
    private Float costo;
    private Date fecha;
    private String socioName;
    private String claseName;
    private DtClase clase;
    private SocioDTO socio;
    private DtPuntuacionProfesor puntuacionProfesor;

    public DtRegistro() {

    }

    public DtRegistro(int id, Float costo, Date fecha, String socioName, String claseName) {
        this.id = id;
        this.costo = costo;
        this.fecha = fecha;
        this.socioName = socioName;
        this.claseName = claseName;

    }

    public DtRegistro(int id, float costo, Date fecha, String socioName, String claseName, DtClase clase, DtPuntuacionProfesor puntuacionProfesor) {
        this.id = id;
        this.costo = costo;
        this.fecha = fecha;
        this.socioName = socioName;
        this.claseName = claseName;
        this.clase = clase;
        this.puntuacionProfesor = puntuacionProfesor;
    }

    public DtRegistro(int id, float costo, Date fecha, String socioName, String claseName, DtClase clase, SocioDTO socio) {
        this.id = id;
        this.costo = costo;
        this.fecha = fecha;
        this.socioName = socioName;
        this.claseName = claseName;
        this.clase = clase;
        this.socio = socio;
    }

    public DtRegistro(int id, float costo, Date fecha, String socioName, String claseName, DtClase clase, SocioDTO socio, DtPuntuacionProfesor puntuacionProfesor) {
        this.id = id;
        this.costo = costo;
        this.fecha = fecha;
        this.socioName = socioName;
        this.claseName = claseName;
        this.clase = clase;
        this.socio = socio;
        this.puntuacionProfesor = puntuacionProfesor;
    }

    public int getId() {
        return id;
    }

    public DtClase getClase() {
        return clase;
    }

    public SocioDTO getSocio() {
        return socio;
    }

    public float getCosto() {
        return costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getSocioName() {
        return socioName;
    }

    public String getClaseName() {
        return claseName;
    }

}
