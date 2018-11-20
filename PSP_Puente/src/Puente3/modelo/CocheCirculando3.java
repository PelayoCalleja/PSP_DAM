/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente3.modelo;

/**
 *
 * @author Annie
 */
public class CocheCirculando3 extends Thread {

    private Coche3 coche;
    private Puente3 puente;

    public CocheCirculando3(Coche3 c, Puente3 p) {
        this.coche = c;
        this.puente = p;
    }

    public Coche3 getCoche() {
        return coche;
    }

    public void setCoche(Coche3 coche) {
        this.coche = coche;
    }

    public Puente3 getPuente() {
        return puente;
    }

    public void setPuente(Puente3 puente) {
        this.puente = puente;
    }

    public void run() {
        System.out.println(puente.cruzarPuente(this));
        puente.salirPuente(this);
    }

}
