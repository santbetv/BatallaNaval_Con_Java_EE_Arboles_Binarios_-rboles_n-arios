package com.BatallaNavalArboles.validadores;

import com.BatallaNavalArboles.execepciones.BatallaNabalExcepcion;
import com.BatallaNavalArboles.modelo.TipoBarco;

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
}
