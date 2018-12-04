
package actividadgestionwc;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona extends Thread {
    
    private String nombre; // Nombre de la persona
    private Water wc; // Wc al que va
    private char sexo; // Si es hombre o mujer

    public Persona(String nombre, Water wc, char sexo) {
        this.nombre = nombre;
        this.wc = wc;
        this.sexo = sexo;
    }
        
    
    public void run() {
        // Entrar al water        
        wc.entrarWc(this);      
         
        // Variable que va a almacenar el tiempo que la persona esta dentro del 
        // water
        int tiempo;
        // Generar aleatoriamente el tiempo que esta en el water
        Random r = new Random();
        tiempo = r.nextInt(501) + 500;
        
        // Dormir el hilo los segundos que tenga en tiempo
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Salir del wc
        wc.salirWC(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Water getWc() {
        return wc;
    }

    public void setWc(Water wc) {
        this.wc = wc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    
    public boolean isHombre(){
        return sexo == 'H';
    }
    
    
    
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", wc=" + wc + ", sexo=" + sexo + '}';
    }

 
 
    
}
