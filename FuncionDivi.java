/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Matriz;

/**
 *
 * @author jais1
 */
public class FuncionDivi extends Thread{
    
    public FuncionDivi() {
    }

    public void dividir(int numArreglo, int Array[][]) throws InterruptedException {
        Hilo h = new Hilo();
        int div = (Array.length * Array.length) / numArreglo;
        int[] subArreglo = new int[div];
        int cont = 0;
        int n = 0;
        int sumatotal = 0;
        for (int j = 0; j < Array.length; j++) {
            for (int k = 0; k < Array.length; k++) {
                subArreglo[cont] = Array[j][k];
                sumatotal = sumatotal + Array[j][k];
                //System.out.println(" " + subArreglo[cont]);
                cont++;
                if (cont == div) {
                    Matriz a = new Matriz("Arreglo " + (n + 1), subArreglo, h);
                    a.start(); 
                    subArreglo = new int[div];
                    //System.out.println("Fin arreglo : " + (n + 1));
                    n++;
                    cont = 0;
                    Thread.sleep(500);
                }
            }
        }
    }  
}
