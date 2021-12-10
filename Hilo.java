package Controlador;

import Modelo.Matriz;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jais1
 */
public class Hilo {

    Semaforo semaforo;
    int sumaTotal = 0;

    public Hilo() {
        this.semaforo = new Semaforo();
    }

    public void sumar(Matriz arreglo) throws InterruptedException {
        System.out.println("El " + arreglo.getNombre() + " empezo a ejecutarse");
        this.semaforo.agregarHilo(arreglo);
        for (int i = 0; i < arreglo.getArreglo().length; i++) {
            //System.out.println(arreglo.getNombre() + " ejecutando " + (i + 1));
            arreglo.setSumaArreglo(arreglo.getSumaArreglo() + arreglo.getArreglo()[i]);
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sumaTotal = sumaTotal + arreglo.getSumaArreglo();
        System.out.println("El " + arreglo.getNombre() + " termino de ejecutarse");
        System.out.println("La suma del " + arreglo.getNombre() + " es: " + arreglo.getSumaArreglo());
        this.semaforo.continuarHilo();
        if (this.semaforo.numeroHilos == this.semaforo.cola.size()) {
            System.out.println("Suma Total " + sumaTotal);
        }
    }
}
