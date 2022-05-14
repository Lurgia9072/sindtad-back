package com.auth.jwt.app.repository;
import com.auth.jwt.app.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TipoDocumentoRepostory extends JpaRepository<TipoDocumento, Integer> {
}
