package com.unico.mapper;

import com.unico.dto.FeiraRequestDTO;
import com.unico.dto.FeiraResponseDTO;
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

    public static FeiraResponseDTO toResponseDto(Feira model) {
        return FeiraResponseDTO.builder()
                .areaP(model.getAreaP())
                .bairro(model.getBairro())
                .id(model.getId())
                .codDist(model.getCodDist())
                .codigoSubPrefeitura(model.getCodigoSubPrefeitura())
                .distrito(model.getDistrito())
                .nomeFeira(model.getNomeFeira())
                .latitude(model.getLatitude())
                .logradouro(model.getLogradouro())
                .longitude(model.getLongitude())
                .numero(model.getNumero())
                .referencia(model.getReferencia())
                .regiao5(model.getRegiao5())
                .regiao8(model.getRegiao8())
                .registro(model.getRegistro())
                .setcens(model.getSetcens())
                .subPrefeitura(model.getSubPrefeitura())
                .build();
    }
}
