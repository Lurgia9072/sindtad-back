package com.auth.jwt.app.repository;

import com.auth.jwt.app.entity.Entidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EntidadRepository extends JpaRepository<Entidad, Integer> {
    @Query("SELECT * FROM tb_entidad u WHERE u.nombre_comercial = ?1")
    Optional<Entidad> buscarEntidadNombreComercial(String nombreComercial);
    @Query("SELECT * FROM tb_entidad u WHERE u.nro_documento = ?1")
    Optional<Entidad> buscarEntidadNroDocumento(String nroDocumento);








}
