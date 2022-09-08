package Registro;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maximilianooliverasilva
 */
public class DtRegistro {
    private int id;
    private float costo;
    private Date fecha;
    private String socioName;
    private String claseName;
    

    public DtRegistro(int id, float costo, Date fecha, String socioName, String claseName) {
        this.id = id;
        this.costo = costo;
        this.fecha = fecha;
        this.socioName = socioName;
        this.claseName = claseName;
    }

    public int getId() {
        return id;
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
