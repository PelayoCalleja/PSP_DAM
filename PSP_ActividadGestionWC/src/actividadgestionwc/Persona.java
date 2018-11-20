
package actividadgestionwc;

import static java.lang.Math.random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona extends Thread{
    
    private String nombre;      //Nombre de la persona
    private Wc wc;              //Wc al que va
    private String sexo;     //Si es hombre o mujer
        
    Persona(String nombre, String sexo, Wc wc){

        this.nombre=nombre;
        this.sexo =sexo;
        this.wc=wc;
    }

    public void run() {
        long tiempo;
        //entra al wc
                 
        wc.entrarWc(this);      
        
        //esta un tiempo x
        tiempo= (long) (random()*100+2000);        
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sale del wc
        wc.salirWC(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Wc getWc() {
        return wc;
    }

    public void setWc(Wc wc) {
        this.wc = wc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
 
    
}
