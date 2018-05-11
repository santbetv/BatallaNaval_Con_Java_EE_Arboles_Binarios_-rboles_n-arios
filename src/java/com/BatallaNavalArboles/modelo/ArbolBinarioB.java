package com.BatallaNavalArboles.modelo;

import com.BatallaNavalArboles.execepciones.BatallaNabalExcepcion;
import com.BatallaNavalArboles.validadores.BatallaValidador;
import com.sun.mail.imap.YoungerTerm;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 12:46:39 AM
 */
public class ArbolBinarioB {

    private NodoABB raiz;

    public ArbolBinarioB() {
    }

    public NodoABB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoABB raiz) {
        this.raiz = raiz;
    }

    public void adicionarNodo(TipoBarco dato) throws BatallaNabalExcepcion {

        BatallaValidador.verificarDatosObligatorios(dato);
        NodoABB nodo = new NodoABB(dato);
        if (raiz == null) {
            raiz = nodo;
        } else {
            adicionarBarco(nodo, raiz);
        }

    }

    private void adicionarBarco(NodoABB nuevo, NodoABB pivote) throws BatallaNabalExcepcion {
        //Selecciono el camino
        if (nuevo.getDato().getNroCasillas() == pivote.getDato().getNroCasillas()) {
            throw new BatallaNabalExcepcion("Ya existe un baco con el " + "Numero de casillas "
                    + nuevo.getDato().getNroCasillas());
        } else if (nuevo.getDato().getNroCasillas() < pivote.getDato().getNroCasillas()) {
            if (pivote.getIzquierda() == null) {
                pivote.setIzquierda(nuevo);
            } else {
                adicionarBarco(nuevo, pivote.getIzquierda());
            }
        } else {
            if (pivote.getDerecha() == null) {
                pivote.setDerecha(nuevo);
            } else {
                adicionarBarco(nuevo, pivote.getDerecha());
            }
        }
    }

    public List listarNodos() {
        List<String> lista = new ArrayList<>();
        return lista;
    }

    public int sumarCantidadBarcos() {
        return sumarCantidadBarcos(raiz);
    }

    public int sumarCantidadBarcos(NodoABB reco) {
        int cont = 0;
        if (reco != null) {
            cont += reco.getDato().getCantidadJuego();
            cont += sumarCantidadBarcos(reco.getIzquierda());
            cont += sumarCantidadBarcos(reco.getDerecha());
        }
        return cont;
    }

    public List<TipoBarco> recorrerPreOrden() {
        List<TipoBarco> listaBarcos = new ArrayList<>();
        recorrerPreOrden(raiz, listaBarcos);
        return listaBarcos;
    }

    private void recorrerPreOrden(NodoABB reco, List<TipoBarco> listaBarcos) {
        if (reco != null) {
            listaBarcos.add(reco.getDato());
            recorrerPreOrden(reco.getIzquierda(), listaBarcos);
            recorrerPreOrden(reco.getDerecha(), listaBarcos);
        }
    }

    //Iniciar consultar padre de infante
    public String padre(String barco) {
        NodoABB esBarco = padre(raiz, barco);
        if (esBarco == null) {
            return "";
        }
        return (esBarco.getDato().getNombre());
    }

    private NodoABB padre(NodoABB reco, String barco) {
        if (reco == null) {
            return null;
        }
        if ((reco.getIzquierda() != null && reco.getIzquierda().getDato().getNombre().equals(barco)) || (reco.getDerecha() != null && reco.getDerecha().getDato().getNombre().equals(barco))) {
            return (reco);
        }
        NodoABB y = padre(reco.getIzquierda(), barco);
        if (y == null) {
            return (padre(reco.getDerecha(), barco));
        } else {
            return (y);
        }
    }
}
