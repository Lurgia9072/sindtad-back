package com.auth.jwt.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int  id_tipo_contribuyente;
   private String  nombre ;
   private int estado ;

    public TipoContribuyente() {
    }

    public int getId_tipo_contribuyente() {
        return id_tipo_contribuyente;
    }

    public void setId_tipo_contribuyente(int id_tipo_contribuyente) {
        this.id_tipo_contribuyente = id_tipo_contribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
