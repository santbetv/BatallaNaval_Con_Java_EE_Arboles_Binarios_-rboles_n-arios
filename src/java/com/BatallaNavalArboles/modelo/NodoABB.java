package com.BatallaNavalArboles.modelo;

import java.io.Serializable;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 12:44:22 AM
 */
public class NodoABB implements Serializable{

    private TipoBarco dato;
    private NodoABB izquierda;
    private NodoABB derecha;

    public NodoABB(TipoBarco dato) {
        this.dato = dato;
    }

    public TipoBarco getDato() {
        return dato;
    }

    public void setDato(TipoBarco dato) {
        this.dato = dato;
    }

    public NodoABB getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoABB izquierda) {
        this.izquierda = izquierda;
    }

    public NodoABB getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoABB derecha) {
        this.derecha = derecha;
    }

}
