/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

import java.util.Date;

/**
 *
 * @author angel
 */
public class ProfesorEditDTO {

    private String nombre;
    private String apellido;
    private String nickname;
    private String descripcionGeneral;
    private String biografia;
    private String linkSitioWeb;
    private String email;
    private Date fechaNacimiento;

    public ProfesorEditDTO(String nombre, String apellido, String nickname, String descripcionGeneral, String biografia, String linkSitioWeb) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
    }

    public ProfesorEditDTO(String nombre, String apellido, String nickname, String descripcionGeneral, String biografia, String linkSitioWeb, String mail, Date fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
        this.email = mail;
        this.fechaNacimiento = fechaNac;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getLinkSitioWeb() {
        return linkSitioWeb;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

}
