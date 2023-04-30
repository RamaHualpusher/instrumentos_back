package com.hualpusher.instrumentos.service;

import java.util.List;

import com.hualpusher.instrumentos.entity.Instrumento;

public interface InstrumentoService {

    List<Instrumento> buscarTodos();

    Instrumento buscarPorId(Long id);

    Instrumento guardarInstrumento(Instrumento instrumento);

    void eliminarInstrumento(Long id);

    List<Instrumento> buscarPorMarca(String marca);

    List<Instrumento> buscarPorPrecioMaximo(double precioMaximo);

}
