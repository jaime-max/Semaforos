/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Hilo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jais1
 */
public class Matriz extends Thread{

    private String nombre;
    private int[] arreglo;
    long velocidad;
    int sumaArreglo = 0;
    boolean estado;
    Hilo hilo;

    public Matriz(String nombre, int[] arreglo, Hilo hilo) {
        this.nombre = nombre;
        this.arreglo = arreglo;
        this.velocidad = (int) (Math.random() * (1000 - 100) + 100);
        this.sumaArreglo = 0;
        this.estado = false;
        this.hilo = hilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    public long getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(long velocidad) {
        this.velocidad = velocidad;
    }

    public int getSumaArreglo() {
        return sumaArreglo;
    }

    public void setSumaArreglo(int sumaArreglo) {
        this.sumaArreglo = sumaArreglo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    @Override
    public void run() {
        try {
            this.hilo.sumar(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
