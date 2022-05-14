package com.auth.jwt.app.service;

import com.auth.jwt.app.entity.TipoContribuyente;

import java.util.List;

public interface ITipoContribuyente {
    List<TipoContribuyente> obtenerTodosTipoContribuyente();

    TipoContribuyente buscarTipoContribuyenteId(Integer id);
}
