package com.BatallaNavalArboles.modelo;

import java.io.Serializable;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 12:39:59 AM
 */
public class TipoBarco implements Serializable {

    private String nombre;
    private byte nroCasillas;
    private byte cantidadJuego;
    private int codigo;

    public TipoBarco() {
    }

    public TipoBarco(String nombre, byte nroCasillas, byte cantidadJuego) {
        this.nombre = nombre;
        this.nroCasillas = nroCasillas;
        this.cantidadJuego = cantidadJuego;
    }

    public TipoBarco(String nombre, byte nroCasillas) {
        this.nombre = nombre;
        this.nroCasillas = nroCasillas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getNroCasillas() {
        return nroCasillas;
    }

    public void setNroCasillas(byte nroCasillas) {
        this.nroCasillas = nroCasillas;
    }

    public byte getCantidadJuego() {
        return cantidadJuego;
    }

    public void setCantidadJuego(byte cantidadJuego) {
        this.cantidadJuego = cantidadJuego;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
