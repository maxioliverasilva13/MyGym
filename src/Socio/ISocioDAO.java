/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Socio;

import java.util.List;

/**
 *
 * @author angel
 */
public interface ISocioDAO {
    public List<Socio> listar();
    public Socio getById(int id);
}