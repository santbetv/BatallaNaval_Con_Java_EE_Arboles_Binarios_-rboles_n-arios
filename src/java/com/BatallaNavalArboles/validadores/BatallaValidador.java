package com.BatallaNavalArboles.validadores;

import com.BatallaNavalArboles.execepciones.BatallaNabalExcepcion;
import com.BatallaNavalArboles.modelo.TipoBarco;
import com.caracolesdecolores.controlador.util.JsfUtil;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 1/04/2018
 * @hora 02:38:04 AM
 */
public class BatallaValidador {

    public static void verificarDatosObligatorios(TipoBarco barco) throws BatallaNabalExcepcion {
        if (barco.getNombre() == null
                || barco.getNombre().equals("")
                || barco.getNombre().startsWith(" ")) {
            throw new BatallaNabalExcepcion("Debe diligenciar el nombre de "
                    + "Barco");
        }
        if (barco.getNroCasillas() < 1) {
            throw new BatallaNabalExcepcion("Debe diligenciar el numero de Casillas");
        }
        if (barco.getCantidadJuego() < 1) {
            throw new BatallaNabalExcepcion("Debe diligenciar la cantidad de Barcos");
        }
    }

    public static void validarLimiteDeTablero(int cantidad, int c, int f, int pos, int casilla) throws BatallaNabalExcepcion {
        if (c == cantidad && pos == 2) {
            throw new BatallaNabalExcepcion("No adicionar Barco de forma Horizontal, Sin casillas");
        }
        if (f == cantidad && pos == 1) {
            throw new BatallaNabalExcepcion("No adicionar Barco de forma Vertical, Sin casillas");
        }
        int sumaFilas = 0;
        sumaFilas = f + casilla;
        if (sumaFilas > (cantidad + 1) && pos == 1) {
            throw new BatallaNabalExcepcion("Imposible Barco supera limites de casillas");
        }
        int sumaColumnas = 0;
        sumaColumnas = c + casilla;
        if (sumaColumnas > (cantidad + 1) && pos == 2) {
            throw new BatallaNabalExcepcion("Imposible Barco supera limites de casillas");
        }
    }

    public static void coordenadaRepetida() throws BatallaNabalExcepcion {
        throw new BatallaNabalExcepcion("Severifica si hay coordenada repetida, si no se adiona, indique de nuevo");
    }
}
