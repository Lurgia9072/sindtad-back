package com.auth.jwt.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_entidad")
public class Entidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entidad ;
    @NotNull
    private String nro_documento;
    @NotNull
    private String razon_social ;
    @NotNull
    private String nombre_comercial ;
    @NotNull
    private String direccion;
    @NotNull
    private String telefono ;
    @NotNull
    private int estado ;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tb_entidad",
            joinColumns = {@JoinColumn(name = "id_tipo_documento")},
            inverseJoinColumns = {@JoinColumn(name = "id_tipo_contribuyente")}
    )
    private List<TipoContribuyente> tipoContribuyente;
    private List<TipoDocumento> tipoDocumento;

    public Entidad(List<TipoContribuyente> tipoContribuyente, List<TipoDocumento> tipoDocumento) {
        this.tipoContribuyente = tipoContribuyente;
        this.tipoDocumento = tipoDocumento;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
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

    public List<TipoContribuyente> getTipoContribuyente() {
        return tipoContribuyente;
    }

    public void setTipoContribuyente(List<TipoContribuyente> tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }

    public List<TipoDocumento> getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(List<TipoDocumento> tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void agregartipoContribuyenteALista(TipoContribuyente tipoContribuyente){
        this.tipoContribuyente.add(tipoContribuyente);
    }

    public void agregarTipoDocumentoALista(TipoDocumento tipoDocumento){
        this.tipoDocumento.add(tipoDocumento);
    }
}
