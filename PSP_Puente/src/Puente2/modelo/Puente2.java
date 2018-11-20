/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente2.modelo;

import Puente1.modelo.Puente1;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Annie
 */
public class Puente2 {

    private String direccionPuente = "";
    private String secuencia = "";
    private boolean ocupado = false;
    private int maxCoches;

    public Puente2() {
    }

    public String getDireccionPuente() {
        return direccionPuente;
    }

    public void setDireccionPuente(String direccionPuente) {
        this.direccionPuente = direccionPuente;
    }

    public int getMaxCoches() {
        return maxCoches;
    }

    public void setMaxCoches(int maxCoches) {
        this.maxCoches = maxCoches;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
/**
 * Coches que quieren pasar por el puente. Solo pueden cruzar en la misma dirección y como máximo,
 * dos coches a la vez.
 * @param cocheC
 * @return 
 */
    public synchronized String cruzarPuente(CocheCirculando2 cocheC) {
        System.out.println("===" + cocheC.getCoche().getNombre() + " quiere pasar por el puente en direccion "
                + cocheC.getCoche().getDireccion());

        while (ocupado && !direccionPuente.equalsIgnoreCase(cocheC.getCoche().getDireccion())
                || maxCoches >= 2) {
            try {
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(Puente1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        direccionPuente = cocheC.getCoche().getDireccion();
        ocupado = true;
        maxCoches++;
        notifyAll();

        System.out.println(cocheC.getCoche().getNombre() + " " + cocheC.getCoche().getDireccion() + " está PASANDO por el puente");
        System.out.println("++++++Total de coches pasando por el puente: " + maxCoches);
        System.out.println("DIRECCIÓN DEL PUENTE: " + direccionPuente);

        secuencia += cocheC.getCoche().getNombre() + " " + cocheC.getCoche().getDireccion() + " - ";

        return secuencia;

    }
    
    /**
     * Los coches tardan un tiempo en cruzar el puente y salen.
     * @param cocheC 
     */

    public synchronized void salirPuente(CocheCirculando2 cocheC) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Puente1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ocupado = false;
        direccionPuente="";
        maxCoches--;
        notifyAll();
System.out.println(cocheC.getCoche().getNombre() + " ha SALIDO del puente");
    }
}
