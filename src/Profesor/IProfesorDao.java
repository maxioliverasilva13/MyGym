/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Profesor.dtos.ProfesorEditDTO;
/**
 *
 * @author angel
 */
public interface IProfesorDao {
   
    public void editById(int id, ProfesorEditDTO editProf);
    public Profesor getByNickname(String nickname);
    public Profesor getById(int id);
 
}
