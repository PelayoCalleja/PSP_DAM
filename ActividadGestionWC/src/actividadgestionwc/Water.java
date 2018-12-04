package actividadgestionwc;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Water {

    private boolean disponible;
    private ArrayList<Persona> secuencia;

    public Water() {
        disponible = true;
        secuencia = new ArrayList<>();
    }

    
    /**
     * la persona entra en el baño si esta libre lo ocupa sino espera
     *
     * @param p Persona que quiere utilizar el baño
     */
    public synchronized void entrarWc(Persona p) {

        while (!disponible) {
            System.out.println("-> " + p.getNombre() + " intenta entrar al wc..");
            try {
                // Si el wc esta ocupado la persona tiene que esperar hasta que 
                // este libre
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Water.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        disponible = false;
        secuencia.add(p);
        System.out.println("++++ "+p.getNombre() + " " + p.getSexo() + " ha entrado al wc");
        System.out.println("-> wc ocupado!");
        notifyAll();
    }

    /**
     * la persona sale del baño, indica cuantos hombres y mujeres han entrado y
     * lo deja libre
     *
     * @param p
     */
    public synchronized void salirWC(Persona p) {
        System.out.println("---- "+p.getNombre() + " ha salido del wc");
       
        contarPersonas();
        imprimirSecuencia();
        disponible = true;
        notifyAll();
    }

    
    
    private void imprimirSecuencia(){
        System.out.println("Secuencia de personas: ");
        for(Persona p : secuencia){
            System.out.print(p.getSexo()+" ");
        }
        System.out.println("");
    }
    
    private void contarPersonas(){
        
        int hombres = 0;
        for(Persona p : secuencia){
           if(p.isHombre()){
               hombres=hombres+1;
           } 
        }
        int mujeres = secuencia.size()-hombres;
        System.out.println("Han entrado " + mujeres + " mujeres y " + hombres + " hombres");
    
    }
    
}
