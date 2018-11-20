/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente3.modelo;

import Puente1.modelo.Puente1;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Annie
 */
public class Puente3 {

    private String secuencia;
    private boolean ocupado = false;
    private String direccionPuente;

    public Puente3() {
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

    public String getDireccionPuente() {
        return direccionPuente;
    }

    public void setDireccionPuente(String direccionPuente) {
        this.direccionPuente = direccionPuente;
    }
    /**
     * Un coche cruza el puente. Si llega otro en la misma dirección,
     * se dispondrá apasar el puente también, sin límite de coches 
     * cruzando el puente a la vez. Sólo se cambiará la direccion
     * cuando no hay ningun coche cruzando el puente
     * @param cocheC
     * @return 
     */

    public synchronized String cruzarPuente(CocheCirculando3 cocheC) {

        System.out.println("===" + cocheC.getCoche().getNombre() + " quiere pasar por el puente en direccion "
                + cocheC.getCoche().getDireccion());
        while (ocupado && !direccionPuente.equalsIgnoreCase(cocheC.getCoche().getDireccion())) {
            try {
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(Puente1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        direccionPuente = cocheC.getCoche().getDireccion();
        ocupado = true;
        notifyAll();

        secuencia += cocheC.getCoche().getNombre() + " " + cocheC.getCoche().getDireccion() + " - ";
        System.out.println(cocheC.getCoche().getNombre() + " " + cocheC.getCoche().getDireccion() + " está PASANDO por el puente");
        System.out.println("DIRECCIÓN DEL PUENTE: " + direccionPuente);

        return secuencia;

    }
    /**
     * El coche tarda un tiempo en cruzar el puente y sale
     * @param cocheC 
     */

    public synchronized void salirPuente(CocheCirculando3 cocheC) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        ocupado = false;
        direccionPuente = "";
        notifyAll();
        System.out.println(cocheC.getCoche().getNombre() + " ha SALIDO del puente");
    }
}
