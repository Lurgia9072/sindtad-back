package com.auth.jwt.app.service;

import com.auth.jwt.app.entity.TipoContribuyente;
import com.auth.jwt.app.repository.TipoContribuyenteRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoContribuyenteService implements ITipoContribuyente{

    @Autowired
    private TipoContribuyenteRepostory tipoContribuyenteRepostory;
    @Override
    public List<TipoContribuyente> obtenerTodosTipoContribuyente() {
        return (List<TipoContribuyente>)tipoContribuyenteRepostory.findAll();
    }

    @Override
    public TipoContribuyente buscarTipoContribuyenteId(Integer id) {
        return  tipoContribuyenteRepostory.findById(id).orElse(null);
    }
}
