/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente2.logica;

import Puente2.modelo.Coche2;
import Puente2.modelo.CocheCirculando2;
import Puente2.modelo.Puente2;

/**
 *
 * @author Annie
 */
public class GestionPuente2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        int numCoches=6;       
        
        Puente2 puente=new Puente2();
        
        for (int i = 1; i <=numCoches; i++) {
        Coche2 coche=new Coche2("Coche" + i);
           
           (new CocheCirculando2(puente, coche)).start();
        }
        
    }
    
}
