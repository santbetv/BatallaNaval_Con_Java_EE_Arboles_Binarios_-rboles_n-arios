package com.BatallaNavalArboles.modelo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 12:52:40 AM
 */
public class BarcoPosicionado implements Serializable {

    private TipoBarco tipoBarco;
    private Coordenada coordenadas[];
    private byte nroImpactos;
    private Estado estado;
    private int identificador;

    public BarcoPosicionado() {
    }

    public BarcoPosicionado(Coordenada[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public BarcoPosicionado(TipoBarco tipoBarco) {
        this.tipoBarco = tipoBarco;
    }

    public BarcoPosicionado(TipoBarco tipoBarco, int identificador) {
        this.tipoBarco = tipoBarco;
    }

    public TipoBarco getTipoBarco() {
        return tipoBarco;
    }

    public void setTipoBarco(TipoBarco tipoBarco) {
        this.tipoBarco = tipoBarco;
    }

    public Coordenada[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public byte getNroImpactos() {
        return nroImpactos;
    }

    public void setNroImpactos(byte nroImpactos) {
        this.nroImpactos = nroImpactos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void validarImpactos() {
    }

    @Override
    public String toString() {
        return tipoBarco.getCodigo() + Arrays.toString(getCoordenadas());
    }
}
