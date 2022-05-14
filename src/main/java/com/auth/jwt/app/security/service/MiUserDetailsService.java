package com.auth.jwt.app.security.service;

import com.auth.jwt.app.entity.Entidad;
import com.auth.jwt.app.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MiUserDetailsService implements UserDetailsService {

    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Entidad> nombreComercial = entidadRepository.buscarEntidadNroDocumento(s);
        nombreComercial.orElseThrow(() -> new UsernameNotFoundException("No se encontro el usuario "+ s
                +" en la BD"));

        return nombreComercial.map(MiUserDetails::new).get();
    }
}
