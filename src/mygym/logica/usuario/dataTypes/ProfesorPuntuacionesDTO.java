/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mygym.logica.usuario.dataTypes;


public class ProfesorPuntuacionesDTO  {
    private double meanPuntuacion;
    private double percentageOne;
    private double percentageTwo;
    private double percentageThree;
    private double percentageFour;
    private double percentageFive;
    
    public ProfesorPuntuacionesDTO(double meanPuntuacion,double percentageOne,double percentageTwo,double percentageThree,double percentageFour,double percentageFive){
        this.meanPuntuacion = meanPuntuacion;
        this.percentageOne = percentageOne;
        this.percentageTwo = percentageTwo;
        this.percentageThree = percentageThree;
        this.percentageFour = percentageFour;
        this.percentageFive = percentageFive;
    }
    
    
    public double getMeanPuntuacion(){
        return this.meanPuntuacion;
    }
    
    public double getPercentageOne(){
        return this.percentageOne;
    }
    
    public double getPercentageTwo(){
        return this.percentageTwo;
    }
    
     public double getPercentageThree(){
        return this.percentageThree;
    }
    
     public double getPercentageFour(){
        return this.percentageFour;
    }
     
    public double getPercentageFive(){
        return this.percentageFive;
    }
     
     
   
    
    
    

}
