package com.hualpusher.instrumentos.service;

import java.util.List;

import com.hualpusher.instrumentos.dao.InstrumentoDao;
import com.hualpusher.instrumentos.entity.Instrumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoServiceImpl implements InstrumentoService {

    @Autowired
    private InstrumentoDao instrumentoDao;

    @Override
    public List<Instrumento> buscarTodos() {
        return instrumentoDao.findAll();
    }

    @Override
    public Instrumento buscarPorId(Long id) {
        return instrumentoDao.findById(id).orElse(null);
    }

    @Override
    public Instrumento guardarInstrumento(Instrumento instrumento) {

        return instrumentoDao.save(instrumento);
    }


    @Override
    public void eliminarInstrumento(Long id) {
        instrumentoDao.deleteById(id);
    }

    @Override
    public List<Instrumento> buscarPorMarca(String marca) {
        return instrumentoDao.findByMarca(marca);
    }

    @Override
    public List<Instrumento> buscarPorPrecioMaximo(double precioMaximo) {
        return instrumentoDao.findByPrecioLessThanEqual(precioMaximo);
    }
}

