package com.unico.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeiraRequestDTO {

    private String longitude;

    private String latitude;

    private String setcens;

    private String areaP;

    private String codDist;

    private String distrito;

    private String codigoSubPrefeitura;

    private String subPrefeitura;

    private String regiao5;

    private String regiao8;

    private String nomeFeira;

    private String registro;

    private String logradouro;

    private String numero;

    private String bairro;

    private String referencia;
}
