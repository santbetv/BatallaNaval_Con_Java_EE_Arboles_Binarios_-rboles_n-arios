package com.BatallaNavalArboles.modelo;

import java.io.Serializable;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 12:26:48 AM
 */
public class Rol implements Serializable{

    private byte codigo;
    private String nombre;

    public Rol(byte codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Rol{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
