package com.auth.jwt.app.payload;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

// Ver si sirve o uso el de usuarios
public class AutenticacionRegistro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nro_documento;

    private String razon_social ;

    private String nombre_comercial ;

    private String direccion;

    private String telefono ;

    private int estado ;

    public AutenticacionRegistro(String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, int estado) {
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
