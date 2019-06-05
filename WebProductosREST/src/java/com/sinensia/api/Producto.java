/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.api;

/**
 *
 * @author Admin - Vanessa
 */
public class Producto {

    private String nombre;
    private String precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre =nombre;
    }

   

    /**
     * Get the value of precio
     *
     * @return the value of precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Set the value of precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }



}
