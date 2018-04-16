package com.BatallaNavalArboles.modelo;

import java.io.Serializable;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 12:48:58 AM
 */
public class Estado implements Serializable{
    
    private byte codigo;
    private String descripcion;

    public Estado(byte codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public byte getCodigo() {
        return codigo;
    }

    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
