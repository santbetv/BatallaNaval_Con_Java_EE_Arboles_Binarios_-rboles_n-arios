package com.BatallaNavalArboles.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 01:21:41 AM
 */
public class ArbolN {

    private NodoN raiz;

    public ArbolN() {
    }

    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }

    //Inicia metodo de adicionar en arbolN Batalla naval creado por el profesor
    public void adicionarNodo(BarcoPosicionado dato, BarcoPosicionado padre) {
        if (raiz == null) {
            raiz = new NodoN(dato);
        } else {
            adicionarNodo(dato, padre, raiz);
        }
    }

    private void adicionarNodo(BarcoPosicionado dato, BarcoPosicionado padre, NodoN pivote) {
        if (pivote.getDato().getTipoBarco().getNombre().compareTo(padre.getTipoBarco().getNombre()) == 0) {
            pivote.getHijos().add(new NodoN(dato));
        } else {
            for (NodoN hijo : pivote.getHijos()) {
                adicionarNodo(dato, padre, hijo);
                if (padre.getTipoBarco().getNombre().compareTo(hijo.getDato().getTipoBarco().getNombre()) == 0) {
                    break;
                }
            }
        }
    }

    public void adicionarNodoxCodigo(BarcoPosicionado dato, BarcoPosicionado padre) {
        if (raiz == null) {
            raiz = new NodoN(dato);

        } else {
            adicionarNodoxCodigo(dato, padre, raiz);

        }

    }

    private void adicionarNodoxCodigo(BarcoPosicionado dato, BarcoPosicionado padre, NodoN pivote) {
        if (pivote.getDato().getTipoBarco().getCodigo() == padre.getTipoBarco().getCodigo()) {
            pivote.getHijos().add(new NodoN(dato));
        } else {
            for (NodoN hijo : pivote.getHijos()) {
                adicionarNodoxCodigo(dato, padre, hijo);
                if (padre.getTipoBarco().getCodigo() == hijo.getDato().getTipoBarco().getCodigo()) {
                    break;
                }

            }
        }
    }
    //Final codigo para adicionar nodos repartidos por codigos

    //Finaliza metodo de adicionar en arbolN Batalla naval creado por el profesor
    public String listarHijosCadena() {
        String info = "";
        ArrayList<String> datos = listarNodos(raiz);
        for (int i = 0; i < datos.size(); i++) {
            info += datos.get(i) + "\n";
        }
        return info;
    }

    public String listarHijos() {
        String info = "";
        ArrayList<NodoN> datos = listarNodosNodos(raiz);
        for (int i = 0; i < datos.size(); i++) {
            info += datos.get(i).getHijos() + "\n";
        }
        return info;
    }

    public int cantidadDePadres(String padres) {
        int cantidad = 0;
        String barco = "";
        ArrayList<String> datos = listarNodos(raiz);
        for (int i = 0; i < datos.size(); i++) {
            barco = datos.get(i);
            if (padres.compareTo(barco) == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private ArrayList listarNodos(NodoN reco) {
        ArrayList<String> nodosBarcos = new ArrayList<>();
        String[] barcos;
        String datos2 = "";
        for (NodoN hijo : reco.getHijos()) {
            nodosBarcos.add(hijo.getDato().getTipoBarco().getNombre());
            datos2 = "" + hijo.getHijos();
            barcos = datos2.split(",");
            for (String barco : barcos) {
                nodosBarcos.add(barco.replace("[", "").replace("]", "").replace(" ", ""));
            }
        }
        return nodosBarcos;
    }

    private ArrayList<NodoN> listarNodosNodos(NodoN reco) {
        ArrayList<NodoN> nodosBarcos = new ArrayList<>();
        for (NodoN hijo : reco.getHijos()) {
            nodosBarcos.add(hijo);
        }
        return nodosBarcos;
    }

    public void buscarBarcoSeleccionado(int barco, byte c, byte f, int posicion) {
        buscarBarcoSeleccionado(barco, raiz, c, f, posicion);
    }

    private boolean buscarBarcoSeleccionado(int barco, NodoN reco, byte c, byte f, int posicion) {
//        System.out.println("PRUEBADEINGRESOBARCOBUSCADO: " + barco);
        if (reco.getDato().getTipoBarco().getCodigo() == barco) {
            byte casillas = reco.getDato().getTipoBarco().getNroCasillas();
            reco.getDato().setCoordenadas(coordenadas(c, f, casillas, posicion));
        } else {
            for (int i = 0; i < reco.getHijos().size(); i++) {
                buscarBarcoSeleccionado(barco, reco.getHijos().get(i), c, f, posicion);
                if (barco == reco.getDato().getTipoBarco().getCodigo()) {
                    return true;
                }
            }
        }
        return false;
    }

    private Coordenada[] coordenadas(byte c, byte f, byte casilla, int posicion) {//Nuevo validar
        int aumentarFila = f - 1;
        int aumentarColumna = c - 1;
        Coordenada[] coordenada = new Coordenada[casilla];
        for (int i = 0; i < coordenada.length; i++) {
            aumentarFila++;
            aumentarColumna++;
            if (posicion == 1) {
                coordenada[i] = new Coordenada(c, (byte) aumentarFila);
            } else if (posicion == 2) {
                coordenada[i] = new Coordenada((byte) aumentarColumna, f);
            }
        }
        return coordenada;
    }

//    private int cont = 0;
//    private Coordenada[] coordenadas(byte c, byte f, byte casilla) {//Nuevo validar
//        Coordenada[] coordenada = new Coordenada[casilla];
//        if (cont < coordenada.length) {
//            coordenada[cont] = new Coordenada(c, f);
//        }
//        cont++;
////        coordenada[0] = new Coordenada((byte) 3, (byte) 2);
////        coordenada[1] = new Coordenada((byte) 1, (byte) 5);
////        coordenada[2] = new Coordenada((byte) 7, (byte) 1);
//        return coordenada;
//    }
}
