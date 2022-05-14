package com.auth.jwt.app.security.service;

import com.auth.jwt.app.entity.Entidad;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Esta clase proporciona la implementacion para establecer informacion del usuario.
 * Almacenando información del usuario que más tarde se encapsula en objetos de autenticación
 */
public class MiUserDetails implements UserDetails {
    private String nro_documento;

    private String razon_social ;

    private String nombre_comercial ;

    private String direccion;

    private String telefono ;

    private int estado ;

    private List<SimpleGrantedAuthority> authorities;


    public MiUserDetails(Entidad entidad){
        this.authorities = new ArrayList<SimpleGrantedAuthority>();
        this.nro_documento = entidad.getNro_documento();
        this.razon_social = entidad.getRazon_social();
        this.nombre_comercial = entidad.getNombre_comercial();
        this.direccion = entidad.getDireccion();
        this.telefono = entidad.getTelefono();
        this.estado = entidad.getEstado();

    } // fin del constructor


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.nro_documento;
    }

    @Override
    public String getUsername() {
        return this.nombre_comercial;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
} // fin de la clase details
