/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Puente1.logica;

import Puente1.modelo.Puente1;
import java.util.Random;
import Puente1.modelo.Coche1;
import Puente1.modelo.CocheCirculando1;

/**
 *
 * @author Annie
 */
public class GestionPuente1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int numCoches=6;
       
        
        Puente1 puente=new Puente1();
        
        for (int i = 1; i <=numCoches; i++) {
        Coche1 coche=new Coche1("Coche" + i);
           
           (new CocheCirculando1(puente, coche)).start();
        }
        
        
    }
    
}
