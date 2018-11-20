/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente1.modelo;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Annie
 */
public class Coche1  {
    private String nombre;
     private Random aleatorio=new Random();
    private String direccion=((int)(Math.round(aleatorio.nextFloat()))==1)?"IDA":"VUELTA";

    public Coche1(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Coche1(String nombre) {
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

 
}
    
    

