/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.BatallaNavalArboles.execepciones;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 07:14:29 AM
 */
public class BatallaNabalExcepcion extends Exception{

    public BatallaNabalExcepcion() {
    }

    public BatallaNabalExcepcion(String message) {
        super(message);
    }

    public BatallaNabalExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public BatallaNabalExcepcion(Throwable cause) {
        super(cause);
    }
    
    

}
