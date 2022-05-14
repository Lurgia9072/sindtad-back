package com.auth.jwt.app.payload;

import java.io.Serializable;

/**
 * Clase usada para mapear los campos del formulario "inicio" para obtener los valores
 */
public class AutenticacionLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombreComercial;
    private String nroDocumento;

    public AutenticacionLogin() {
    }

    public AutenticacionLogin(String nombreComercial, String nroDocumento) {
        this.nombreComercial = nombreComercial;
        this.nroDocumento = nroDocumento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
} // fin de la clase
