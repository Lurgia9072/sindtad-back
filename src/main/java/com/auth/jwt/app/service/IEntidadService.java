package com.auth.jwt.app.service;

import com.auth.jwt.app.entity.Entidad;
import java.util.List;

public interface IEntidadService  {

    List<Entidad> buscarTodoEntidad();

    Entidad buscarEntidadPorId(Integer idEntidad);

    Entidad buscarEntidadPorTipoDoc(String tipoDocumento);

    Entidad buscarEntidadPorNombreComer(String nombreComenrcial);


    void guardarEntidad(Entidad entidad);

    void eliminarUsuarioPorId(Integer idUsuario);
}
