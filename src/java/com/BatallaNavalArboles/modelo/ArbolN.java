package com.BatallaNavalArboles.modelo;

import com.BatallaNavalArboles.execepciones.BatallaNabalExcepcion;
import com.BatallaNavalArboles.validadores.BatallaValidador;
import com.caracolesdecolores.controlador.util.JsfUtil;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void eliminarCoordenadas() {
        for (BarcoPosicionado listarNodo : listarNodos()) {
            listarNodo.setCoordenadas(null);
        }
    }

    //Inicio de listar nodos
    public List<BarcoPosicionado> listarNodos() {
        List<BarcoPosicionado> barcos = new ArrayList<>();
        if (raiz != null) {
            for (NodoN nodo : raiz.getHijos()) {
                barcos.addAll(listarNodos(nodo.getHijos()));
                barcos.add(nodo.getDato());
            }
        }
        return barcos;
    }

    private List listarNodos(List<NodoN> nodos) {
        List<BarcoPosicionado> barcos = new ArrayList<>();
        for (NodoN nodo : nodos) {
            barcos.addAll(listarNodos(nodo.getHijos()));
            barcos.add(nodo.getDato());
        }
        return barcos;
    }

    //Final de listar nodos
    public List<Coordenada> acumCoordenadas() {
        List<Coordenada> barcos = new ArrayList<>();
        if (raiz != null) {
            for (NodoN nodo : raiz.getHijos()) {
                barcos.addAll(acumCoordenadas(nodo.getHijos()));
                if (nodo.getDato().getCoordenadas() != null) {
                    for (Coordenada coor : nodo.getDato().getCoordenadas()) {
                        barcos.add(coor);
                    }
                }
            }
        }
        return barcos;
    }

    private List acumCoordenadas(List<NodoN> nodos) {
        List<Coordenada> barcos = new ArrayList<>();
        for (NodoN nodo : nodos) {
            barcos.addAll(acumCoordenadas(nodo.getHijos()));
            if (nodo.getDato().getCoordenadas() != null) {
                for (Coordenada coor : nodo.getDato().getCoordenadas()) {
                    barcos.add(coor);
                }
            }
        }
        return barcos;
    }

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

    private Coordenada[] datosCoor;

    public Coordenada[] agregarCoordenadas() {
        return datosCoor;
    }

    ArrayList<String> l = new ArrayList<>();

    public String datosCoorSimples() {
        String info = "";
        for (int i = 0; i < l.size(); i++) {
            info = l.get(i).replace("[", "").replace("]", "") + ",";
        }
        System.out.println("PRUEBADELISTA: " + info);
        return info;
    }

    private int cantidadDeCasillas = 0;

    public String verificarImagen() {
        return verificarImagen(cantidadDeCasillas);
    }

    private String verificarImagen(int casillas) {
        int contando = 0;
        String retornoDePosImagen = "";
        for (int i = 0; i < casillas; i++) {
            contando++;
            if (contando == 1) {
                retornoDePosImagen += "<" + ",";
            }
            if (contando != 1 && contando != casillas) {
                retornoDePosImagen += "=" + ",";
            }
            if (contando == casillas) {
                retornoDePosImagen += ">";
            }
        }
        return retornoDePosImagen;
    }

    public void buscarBarcoSeleccionado(int barco, byte c, byte f, int posicion, int cantidad) throws BatallaNabalExcepcion {
        buscarBarcoSeleccionado(barco, raiz, c, f, posicion, cantidad);
    }

    private boolean buscarBarcoSeleccionado(int barco, NodoN reco, byte c, byte f, int posicion, int cantidad) throws BatallaNabalExcepcion {
        String prueba = "";
        if (reco.getDato().getTipoBarco().getCodigo() == barco) {
            byte casillas = reco.getDato().getTipoBarco().getNroCasillas();
            datosCoor = (coordenadas(c, f, casillas, posicion, cantidad));
            JsfUtil.addSuccessMessage("POSICIONADO!!");
            reco.getDato().setCoordenadas(coordenadas(c, f, casillas, posicion, cantidad));
            cantidadDeCasillas = casillas;
            //Prueba de datos
            prueba = Arrays.toString(datosCoor);
            l.add(prueba);
            System.out.println("asignarcoor: " + prueba);
            //Prueba de datos
        } else {
            for (int i = 0; i < reco.getHijos().size(); i++) {
                buscarBarcoSeleccionado(barco, reco.getHijos().get(i), c, f, posicion, cantidad);
                if (barco == reco.getDato().getTipoBarco().getCodigo()) {
                    return true;
                }
            }
        }
        return false;
    }

    private Coordenada[] coordenadas(byte c, byte f, byte casilla, int posicion, int cantidad) throws BatallaNabalExcepcion {//Nuevo validar
        int aumentarFila = f - 1;
        int aumentarColumna = c - 1;
        Coordenada[] coordenada = new Coordenada[casilla];
        for (int i = 0; i < coordenada.length; i++) {
            aumentarFila++;
            aumentarColumna++;
            if (posicion == 1) {
                BatallaValidador.validarLimiteDeTablero(cantidad, c, f, posicion, casilla);//modifico
                if (pruebaDeCoordenadas(raiz, c, aumentarFila)) {
                    BatallaValidador.coordenadaRepetida();
                } else {
                    coordenada[i] = new Coordenada(c, (byte) aumentarFila);
                }
            } else if (posicion == 2) {
                BatallaValidador.validarLimiteDeTablero(cantidad, c, f, posicion, casilla);//modifico
                if (pruebaDeCoordenadas(raiz, aumentarColumna, f)) {
                    BatallaValidador.coordenadaRepetida();
                } else {
                    coordenada[i] = new Coordenada((byte) aumentarColumna, f);
                }
            }
        }
        return coordenada;
    }

    private boolean pruebaDeCoordenadas(NodoN reco, int disparoColumna, int disparoFila) {
        if (reco != null) {
            if (reco.getDato().getTipoBarco().getCodigo() != 0 && reco.getDato().validarCoordenada(disparoColumna, disparoFila)) {
                return true;
            } else {
                for (NodoN hijo : reco.getHijos()) {
                    if (pruebaDeCoordenadas(hijo, disparoColumna, disparoFila)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String nombreDeBarco = "";

    //Inicio de Metodo creado para identificar nombre de barco seleccionado
    public String buscarNombreDeBarco(int barco, NodoN reco) {
        if (reco.getDato().getTipoBarco().getCodigo() == barco) {
            nombreDeBarco = reco.getDato().getTipoBarco().getNombre();
            return nombreDeBarco;
        } else {
            for (int i = 0; i < reco.getHijos().size(); i++) {
                buscarNombreDeBarco(barco, reco.getHijos().get(i));
                if (barco == reco.getHijos().get(i).getDato().getTipoBarco().getCodigo()) {
                    nombreDeBarco = reco.getHijos().get(i).getDato().getTipoBarco().getNombre();
                    return nombreDeBarco;
                }
            }
        }
        return nombreDeBarco;
    }
    //Final de Metodo creado para identificar nombre de barco seleccionado

}
