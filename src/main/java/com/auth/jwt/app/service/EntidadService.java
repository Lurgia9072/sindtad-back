package com.auth.jwt.app.service;

import com.auth.jwt.app.entity.Entidad;
import com.auth.jwt.app.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EntidadService implements IEntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Entidad> buscarTodoEntidad() {
        return (List<Entidad>) entidadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Entidad buscarEntidadPorId(Integer idEntidad) {
        return  entidadRepository.findById(idEntidad).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Entidad buscarEntidadPorTipoDoc(String tipoDocumento) {
        return entidadRepository.buscarEntidadNroDocumento(tipoDocumento).orElse(null);
    }


    @Override
    @Transactional(readOnly = true)
    public Entidad buscarEntidadPorNombreComer(String nombreComenrcial) {
        return entidadRepository.buscarEntidadNombreComercial(nombreComenrcial).orElse(null);
    }



    @Override
    @Transactional(readOnly = false)
    public void guardarEntidad(Entidad entidad) {
        entidadRepository.save(entidad);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminarUsuarioPorId(Integer idUsuario) {
        entidadRepository.deleteById(idUsuario);
    }
}
