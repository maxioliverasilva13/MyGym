/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;

import CompraCuponera.CompraCuponera;
import PuntuacionProfesor.PuntuacionProfesor;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import Registro.Registro;
import Socio.dtos.SocioDTO;
import Usuario.Usuario;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;
import Registro.DtRegistro;


@Entity
@PrimaryKeyJoinColumn(name = "userId")
public class Socio extends Usuario{
    
    @OneToMany(mappedBy = "socio")
    private List<Registro> registros;
    
    @OneToMany(mappedBy = "socio")
    private List<CompraCuponera> comprasCuponeras;
    
    
    
    public void addRegistro(Registro r) {
        this.registros.add(r);
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }
    
    public List<CompraCuponera> getCuponerasCompradas(){
        return this.comprasCuponeras;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public void setPassword(String pass) {
        this.password = pass;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }
    

    public SocioDTO getDtSocio() {
        List<DtRegistro> registros = new ArrayList();
        
        this.getRegistros().forEach((registro) ->{
            registros.add(registro.getDtRegistro());
        });

        return new SocioDTO(this.getId(), this.getNombre(),this.getApellido(),this.getNickname(),this.getEmail(),this.getNacimiento(), null, this.createTempFile(), null,null, this.getImage()); 
    }
    

  
    
    
    
}