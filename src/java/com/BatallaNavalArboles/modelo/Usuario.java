package com.BatallaNavalArboles.modelo;

import java.io.Serializable;

/**
 * @author Santiago Betancur Villegas <santiago-betancur at hotmail.com>
 * @fecha 31/03/2018
 * @hora 01:31:23 AM
 */
public class Usuario implements Serializable{

    private String correo;
    private String password;
    private Rol tipoRol;

    public Usuario() {
    }
    
    public Usuario(String correo, String password, Rol tipoRol) {
        this.correo = correo;
        this.password = password;
        this.tipoRol = tipoRol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(Rol tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", password=" + password + ", tipoRol=" + tipoRol + '}';
    }
    
    

}
