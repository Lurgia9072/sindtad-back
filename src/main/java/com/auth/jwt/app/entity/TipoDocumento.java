package com.auth.jwt.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_tipo_documento")
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_documento;
    @Column(name = "codigo")
    private String  codigo ;
    private String nombre;
    private String  descripcion;
    private int estado ;

    public TipoDocumento() {
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
