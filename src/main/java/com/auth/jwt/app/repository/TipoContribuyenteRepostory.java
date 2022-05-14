package com.auth.jwt.app.repository;

import com.auth.jwt.app.entity.TipoContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContribuyenteRepostory extends JpaRepository<TipoContribuyente, Integer> {
}
