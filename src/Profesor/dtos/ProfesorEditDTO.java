/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

import java.io.File;
import java.util.Date;

/**
 *
 * @author angel
 */
public class ProfesorEditDTO {

    private String nombre; //
    private String apellido; //
    private String nickname; //
    private char[] password;
    private String descripcionGeneral; //
    private String biografia; //
    private String linkSitioWeb; //
    private String email; //
    private Date fechaNacimiento; //
    private File image;

    public File getImage() {
        return image;
    }
    
    public ProfesorEditDTO(String nombre, String apellido, String nickname, char[] pass, String descripcionGeneral, String biografia, String linkSitioWeb, String mail, Date fechaNac, File file) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.password = pass;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
        this.email = mail;
        this.fechaNacimiento = fechaNac;
        this.image = file;
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
    
    public char[] getPasswordChar() {
        return password;
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
