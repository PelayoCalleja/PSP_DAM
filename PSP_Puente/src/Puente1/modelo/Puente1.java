/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente1.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import Puente1.modelo.Coche1;
import java.util.Random;

/**
 *
 * @author Annie
 */
public class Puente1 {
 
    private String direccionPuente="";
    private String secuencia="";
    private boolean ocupado=false;
    
    /**
     * Un coche intenta pasar por el puente. Si ya hay otro coche que está pasando por el
     * puente, nos dirá que está ocupado y tendrá que esperar
     * @param coche 
     */
    public synchronized String cruzarPuente(CocheCirculando1 cocheC){
         System.out.println("===" + cocheC.getCoche().getNombre() + " quiere pasar por el puente en direccion "
         + cocheC.getCoche().getDireccion());
        while(ocupado){
           
       try{
           System.out.println(cocheC.getCoche().getNombre()+" está ESPERANDO");
           wait();
       }    catch (InterruptedException ex) {
                Logger.getLogger(Puente1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        System.out.println(cocheC.getCoche().getNombre()+" "+cocheC.getCoche().getDireccion()+" está PASANDO por el puente");
        System.out.println("PUENTE OCUPADO");
        secuencia+=cocheC.getCoche().getNombre() +" "+  cocheC.getCoche().getDireccion() + " - ";
         ocupado=true;
           notifyAll();
           return secuencia;
           
    }
    /**
     * Nos dice cúantos coches han ido y cuántos han venido y nos muestra la secuencia
     * con las palabras "IDA" y "VUELTA" según hayan ido o venido.
     * @param coche 
     */
    public synchronized void salirPuente(CocheCirculando1 cocheC){
        try{
            Thread.sleep(2500);
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Puente1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(cocheC.getCoche().getNombre()+" ha SALIDO del puente");
        ocupado=false;
        notifyAll();
    }
    
    public Puente1() {
    }

    public String getDireccionPuente() {
        return direccionPuente;
    }

    public void setDireccionPuente(String direccionPuente) {
        this.direccionPuente = direccionPuente;
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
    
}
