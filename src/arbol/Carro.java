/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author Reinel
 */
public class Carro {
    String marca;
    int horas;
    String placa;
    
    public Carro(String mar,int hor,String plac){
    marca = mar;
    horas = hor;
    placa = plac;
               
    }

    Carro(String eliminar, int op, int op0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int ascii(){
    int var;
    var = marca.codePointAt(0);
    return var;
    }
    public String Conductor(){
    return marca;
    }
     public int Hora(){
    return horas;
    }
      public String Placa(){
    return placa;
    }
}
