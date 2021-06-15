package com.unico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_feira")
public class Feira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LONG")
    private String longitude;

    @Column(name = "LAT")
    private String latitude;

    @Column(name = "SETCENS")
    private String setcens;

    @Column(name = "AREAP")
    private String areaP;

    @Column(name = "CODDIST")
    private String codDist;

    @Column(name = "DISTRITO")
    private String distrito;

    @Column(name = "CODSUBPREF")
    private String codigoSubPrefeitura;

    @Column(name = "SUBPREFE")
    private String subPrefeitura;

    @Column(name = "REGIAO5")
    private String regiao5;

    @Column(name = "REGIAO8")
    private String regiao8;

    @Column(name = "NOME_FEIRA")
    private String nomeFeira;

    @Column(name = "REGISTRO")
    private String registro;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "REFERENCIA")
    private String referencia;

}
