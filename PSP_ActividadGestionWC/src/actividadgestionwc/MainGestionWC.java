package actividadgestionwc;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class MainGestionWC {

    public static void main(String[] args) {
        final int NUMEROPERSONAS = 10; //número de personas
        //Semilla para generar nÃúmeros aleatorios
        Random generador = new Random();
        String sexo; //Hombre o mujer
        String nombre; //identifica la persona

        //creamos el Wc a compartir
        Wc wc = new Wc();

        for (int i = 1; i <= NUMEROPERSONAS; i++) {
            nombre = "P-" + i;

            sexo = ((int) (Math.round(generador.nextFloat())) == 1) ? "H" : "M";

            //Creando el objeto y arrancando el hilo, simultaneamente
            new Persona(nombre, sexo, wc).start();
         
            //tiempo que tarda en llegar otra persona con ganas de ir al WC
           /* try {
                Thread.sleep((long) (Math.random()*500+50));
            } catch (InterruptedException ex) {
                Logger.getLogger(MainGestionWC.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }
    }
}
