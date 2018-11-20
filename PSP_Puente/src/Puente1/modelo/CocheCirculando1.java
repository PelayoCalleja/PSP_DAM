/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente1.modelo;

/**
 *
 * @author Annie
 */
public class CocheCirculando1 extends Thread {
    private Puente1 puente;
    private Coche1 coche;

    public CocheCirculando1(Puente1 p, Coche1 c) {
        puente = p;
        coche = c;
    }

    public Puente1 getPuente() {
        return puente;
    }

    public void setPuente(Puente1 puente) {
        this.puente = puente;
    }

    public Coche1 getCoche() {
        return coche;
    }

    public void setCoche(Coche1 coche) {
        this.coche = coche;
    }

   

    @Override
    public void run() {
        System.out.println(puente.cruzarPuente(this));
        puente.salirPuente(this);
    }

  
}
