package com.auth.jwt.app.service;

import com.auth.jwt.app.entity.TipoDocumento;

import java.util.List;

public interface ITipoDocumento {

    List<TipoDocumento> obtenerTodosTipoDocumentos();
    TipoDocumento buscarTipoDocumentoId(Integer id);
}
