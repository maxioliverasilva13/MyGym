/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguidor;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import Usuario.Usuario;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maximiliano Olivera
 */
@Entity
@Table()
public class Seguidor implements Serializable {
    @Id
    @ManyToOne()
    @JoinColumn()
    private Usuario persona;
    @Id
    @ManyToOne()
    @JoinColumn()
    private Usuario sigueA;

    public Usuario getPersona() {
        return persona;
    }

    public void setPersona(Usuario persona) {
        this.persona = persona;
    }

    public Usuario getSigueA() {
        return sigueA;
    }

    public void setSigueA(Usuario sigueA) {
        this.sigueA = sigueA;
    }

    public Seguidor(){
        
    }
    

}