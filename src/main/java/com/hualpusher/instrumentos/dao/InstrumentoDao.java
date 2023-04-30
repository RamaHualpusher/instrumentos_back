package com.hualpusher.instrumentos.dao;

import java.util.List;

import com.hualpusher.instrumentos.entity.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentoDao extends JpaRepository<Instrumento, Long> {
    List<Instrumento> findByMarca(String marca);
    List<Instrumento> findByPrecioLessThanEqual(double precio);
}

