/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente3.modelo;

import java.util.Random;

/**
 *
 * @author Annie
 */
public class Coche3 {

    private Random aleatorio = new Random();
    private String direccion = ((int) (Math.round(aleatorio.nextFloat())) == 1) ? "IDA" : "VUELTA";
    private String nombre;

    public Coche3(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Coche3(String nombre) {
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

    @Override
    public String toString() {
        return "Coche{" + "nombre=" + nombre + ", direccion=" + direccion + '}';
    }

}
