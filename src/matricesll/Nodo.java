/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesll;

/**
 *
 * @author Felipe Cadavid
 * @author Carolina Diaz
 * @author Luis Angel Vanegas
 * @version 14-09-2017
 * 
 */
public class Nodo {
    
     //siendo [0]ID, [1] nombre, [2] sexo, [3]salario
     private Tripleta t;
     private Nodo liga; //atributos

    public Nodo(Tripleta t) {
        this.t = t;
        liga = null;
        
    }

    public Tripleta getT() {
        return t;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
  
     

}
