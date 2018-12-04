package actividadgestionwc;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainGestionWC {

    public static void main(String[] args) {
        final int NUM_DE_PERSONAS = 10; //número de personas
        // Generador de numeros aleatorios
        Random r = new Random();
        char sexo; // H-ombre o M-ujer
        String nombre; // identifica la persona
        int tiempo; // El tiempo que tarda en decidir ir al baño
        
        // Crear el objeto que se va a compartir
        Water wc = new Water();

        for (int i = 1; i <= NUM_DE_PERSONAS; i++) {
            nombre = "P" + i;
            // Generar un numero aleatorio para decidir el sexo de la persona
            int hom = r.nextInt(2);
            if (hom == 0) {
                sexo = 'H';
            } else {
                sexo = 'M';
            }
            // Crear el objeto
            Persona p = new Persona(nombre, wc, sexo);
            // Lanzar el hilo   
            p.start();

            // Tiempo entre la generación de una persona y otra
            tiempo = r.nextInt(1001) + 1000;
        
            // Dormir el hilo los segundos que tenga en tiempo
            // Simula el tiempo que la persona tarda en decidir que quiere
            // ir al wc
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
