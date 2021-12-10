package Controlador;

import Modelo.Matriz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jais1
 */
public class Semaforo {

    List<Matriz> cola;
    int numeroHilos;

    public Semaforo() {
        numeroHilos = 0;
        this.cola = new ArrayList();
    }

    public void agregarHilo(Matriz matriz) throws InterruptedException {
        cola.add(matriz);
        if (cola.size() == 1) {
            cola.get(numeroHilos).setEstado(true);
        } else if (cola.get(numeroHilos).isEstado() == true) {
            pararHilo(matriz);
        }
    }

    public void pararHilo(Matriz matriz) throws InterruptedException {
        int ubicacion = 0;
        int i = 0;
        for (Matriz matriz1 : cola) {
            if (matriz1.getNombre().equals(matriz.getNombre())) {
                ubicacion = i;
            } else {
                i++;
            }
        }
        System.out.println("Poniendo en espera " + cola.get(ubicacion).getNombre());
        while (cola.get(ubicacion).isEstado() == false) {
            Thread.sleep(10);
        }
    }

    public void continuarHilo() {
        numeroHilos++;
        if (numeroHilos != cola.size()) {
            System.out.println("Reanunado " + cola.get(numeroHilos).getNombre());
            cola.get(numeroHilos).setEstado(true);
        }
    }
}
