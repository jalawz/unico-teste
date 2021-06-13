package com.unico.mapper;

import com.unico.dto.FeiraRequestDTO;
import com.unico.model.Feira;

public class FeiraMapper {

    public static Feira toModelRequest(FeiraRequestDTO dto) {
        return Feira.builder()
                .areaP(dto.getAreaP())
                .bairro(dto.getBairro())
                .codDist(dto.getCodDist())
                .codigoSubPrefeitura(dto.getCodigoSubPrefeitura())
                .distrito(dto.getDistrito())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .nomeFeira(dto.getNomeFeira())
                .logradouro(dto.getLogradouro())
                .numero(dto.getNumero())
                .referencia(dto.getReferencia())
                .regiao5(dto.getRegiao5())
                .regiao8(dto.getRegiao8())
                .registro(dto.getRegistro())
                .setcens(dto.getSetcens())
                .subPrefeitura(dto.getSubPrefeitura())
                .build();
    }
}
