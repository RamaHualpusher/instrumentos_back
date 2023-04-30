package com.hualpusher.instrumentos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "instrumento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instrumento extends Base {
    @Column(name = "instrumento")
    private String instrumento;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "precio")
    private double precio;
    @Column(name = "costo_envio")
    private String costoEnvio;
    @Column(name = "cantidad_vendida")
    private int cantidadVendida;
    @Column(name = "descripcion")
    @Length(max = 1024)
    private String descripcion;

}
