/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import Controlador.FuncionDivi;

/**
 *
 * @author jais1
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        int[][] numAl = new int[100][100];
        for (int i = 0; i < numAl.length; i++) {
            for (int j = 0; j < numAl.length; j++) {
                 numAl[i][j] = (int) (Math.random() * 100);
            }
        }
        
        FuncionDivi fd = new FuncionDivi();
        fd.dividir(10, numAl);
    }
    
}
