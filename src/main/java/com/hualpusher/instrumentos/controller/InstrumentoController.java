package com.hualpusher.instrumentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hualpusher.instrumentos.entity.Instrumento;
import com.hualpusher.instrumentos.service.InstrumentoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InstrumentoController {

    @Autowired
    private InstrumentoService instrumentoService;

    @GetMapping("/instrumentos")
    public ResponseEntity<List<Instrumento>> buscarTodos() {
        List<Instrumento> instrumentos = instrumentoService.buscarTodos();
        return new ResponseEntity<>(instrumentos, HttpStatus.OK);
    }


    @GetMapping("/instrumentos/{id}")
    public ResponseEntity<Instrumento> buscarPorId(@PathVariable Long id) {
        Instrumento instrumento = instrumentoService.buscarPorId(id);

        if (instrumento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(instrumento, HttpStatus.OK);
    }

    @PostMapping("/instrumentos")
    public ResponseEntity<Instrumento> guardarInstrumento(@RequestBody Instrumento instrumento) {
        Instrumento nuevoInstrumento = instrumentoService.guardarInstrumento(instrumento);
        return new ResponseEntity<>(nuevoInstrumento, HttpStatus.CREATED);
    }

    @PutMapping("/instrumentos/{id}")
    public ResponseEntity<Instrumento> actualizarInstrumento(@PathVariable Long id, @RequestBody Instrumento instrumentoActualizado) {
        Instrumento instrumento = instrumentoService.buscarPorId(id);

        if (instrumento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        instrumento.setInstrumento(instrumentoActualizado.getInstrumento());
        instrumento.setMarca(instrumentoActualizado.getMarca());
        instrumento.setModelo(instrumentoActualizado.getModelo());
        instrumento.setImagen(instrumentoActualizado.getImagen());
        instrumento.setPrecio(instrumentoActualizado.getPrecio());
        instrumento.setCostoEnvio(instrumentoActualizado.getCostoEnvio());
        instrumento.setCantidadVendida(instrumentoActualizado.getCantidadVendida());
        instrumento.setDescripcion(instrumentoActualizado.getDescripcion());

        Instrumento instrumentoActualizadoEnBd = instrumentoService.guardarInstrumento(instrumento);

        return new ResponseEntity<>(instrumentoActualizadoEnBd, HttpStatus.OK);
    }

    @DeleteMapping("/instrumentos/{id}")
    public ResponseEntity<HttpStatus> eliminarInstrumento(@PathVariable Long id) {
        Instrumento instrumento = instrumentoService.buscarPorId(id);

        if (instrumento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        instrumentoService.eliminarInstrumento(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/instrumentos/marca/{marca}")
    public List<Instrumento> buscarPorMarca(@PathVariable String marca) {
        return instrumentoService.buscarPorMarca(marca);
    }

    @GetMapping("/instrumentos/precio/{precioMaximo}")
    public List<Instrumento> buscarPorPrecioMaximo(@PathVariable double precioMaximo) {
        return instrumentoService.buscarPorPrecioMaximo(precioMaximo);
    }
}
