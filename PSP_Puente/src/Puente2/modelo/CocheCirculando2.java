/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente2.modelo;

/**
 *
 * @author Annie
 */
public class CocheCirculando2 extends Thread {
    
    private Puente2 puente;
    private Coche2 coche;

    public CocheCirculando2(Puente2 p, Coche2 c) {
        this.puente = p;
        this.coche = c;
    }

    public Puente2 getPuente() {
        return puente;
    }

    public void setPuente(Puente2 puente) {
        this.puente = puente;
    }

    public Coche2 getCoche() {
        return coche;
    }

    public void setCoche(Coche2 coche) {
        this.coche = coche;
    }
    
    public void run(){
        System.out.println(puente.cruzarPuente(this));
        puente.salirPuente(this);
    }
    
    
}
