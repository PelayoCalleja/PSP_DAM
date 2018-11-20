/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente3.logica;

import Puente2.modelo.Coche2;
import Puente2.modelo.CocheCirculando2;
import Puente2.modelo.Puente2;
import Puente3.modelo.Coche3;
import Puente3.modelo.CocheCirculando3;
import Puente3.modelo.Puente3;

/**
 *
 * @author Annie
 */
public class GestionPuente3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
          int numCoches=6;       
        
        Puente3 puente=new Puente3();
        
        for (int i = 1; i <=numCoches; i++) {
        Coche3 coche=new Coche3("Coche" + i);
           
           (new CocheCirculando3(coche, puente)).start();
        }
        
        
    }
    
}
