package com.unico.service;

import com.unico.exception.ObjectNotFoundException;
import com.unico.model.Feira;
import com.unico.repository.FeiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeiraService {

    private final FeiraRepository feiraRepository;

    public List<Feira> buscarFeirasLivres(String filtro) {
        if (Objects.isNull(filtro) || filtro.length() == 0) {
            return feiraRepository.findAll();
        }

        return feiraRepository.findByDistritoOrRegiao5OrNomeFeiraOrBairro(filtro.toUpperCase(), filtro,
                filtro.toUpperCase(), filtro.toUpperCase());
    }

    public Feira buscarPorId(Integer id) {
        return feiraRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format("Feira com id = %d não encontrada", id)
                ));
    }

    public Feira criarNovaFeira(Feira feira) {
        return feiraRepository.save(feira);
    }

    public Feira atualizarFeira(Feira feira, Integer id) {
        Feira feiraDB = buscarPorId(id);
        updateFeira(feira, feiraDB);
        return feiraRepository.save(feiraDB);
    }

    public void deletarFeira(Integer id) {
        this.buscarPorId(id);
        feiraRepository.deleteById(id);
    }

    private void updateFeira(Feira updateRequest, Feira fromDb) {
        fromDb.setBairro(updateRequest.getBairro());
        fromDb.setAreaP(updateRequest.getAreaP());
        fromDb.setCodDist(updateRequest.getCodDist());
        fromDb.setCodigoSubPrefeitura(updateRequest.getCodigoSubPrefeitura());
        fromDb.setLatitude(updateRequest.getLatitude());
        fromDb.setLongitude(updateRequest.getLongitude());
        fromDb.setDistrito(updateRequest.getDistrito());
        fromDb.setLogradouro(updateRequest.getLogradouro());
        fromDb.setNomeFeira(updateRequest.getNomeFeira());
        fromDb.setNumero(updateRequest.getNumero());
        fromDb.setReferencia(updateRequest.getReferencia());
        fromDb.setRegiao5(updateRequest.getRegiao5());
        fromDb.setRegiao8(updateRequest.getRegiao8());
        fromDb.setSetcens(updateRequest.getSetcens());
        fromDb.setSubPrefeitura(updateRequest.getSubPrefeitura());
        fromDb.setRegistro(updateRequest.getRegistro());
    }
}
