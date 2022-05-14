package com.auth.jwt.app.service;

import com.auth.jwt.app.entity.TipoDocumento;

import com.auth.jwt.app.repository.TipoDocumentoRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoDocumentoService implements ITipoDocumento{
    @Autowired
    private TipoDocumentoRepostory tipoDocumentoRepostory;

    @Override
    public List<TipoDocumento> obtenerTodosTipoDocumentos() {
        return (List<TipoDocumento>) tipoDocumentoRepostory.findAll();
    }

    @Override
    public TipoDocumento buscarTipoDocumentoId(Integer id) {
        return tipoDocumentoRepostory.findById(id).orElse(null);
    }
}