/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author victorhugo
 */
public class Lista {
    String nombre ;
    String direccion ;
    String cod_cancion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCod_cancion() {
        return cod_cancion;
    }

    public void setCod_cancion(String cod_cancion) {
        this.cod_cancion = cod_cancion;
    }

    public Lista(String nombre, String direccion, String cod_cancion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cod_cancion = cod_cancion;
    }
    
    
    
}
