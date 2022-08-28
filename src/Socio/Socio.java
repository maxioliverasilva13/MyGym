/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import Registro.Registro;
import Usuario.Usuario;
import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Socio extends Usuario{
    
    @OneToMany(mappedBy = "socio")
    private Collection<Registro> registros;
    
}