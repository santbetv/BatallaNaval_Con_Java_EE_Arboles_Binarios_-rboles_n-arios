package com.BatallaNavalArboles.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 01:16:43 AM
 */
public class NodoN implements Serializable {

    private BarcoPosicionado dato;
    private List<NodoN> hijos;

    public NodoN(BarcoPosicionado dato) {
        this.dato = dato;
        hijos = new ArrayList<>();
    }

    public BarcoPosicionado getDato() {
        return dato;
    }

    public void setDato(BarcoPosicionado dato) {
        this.dato = dato;
    }

    public List<NodoN> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoN> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return "" + dato.getTipoBarco() + "," + hijos;
    }

}
