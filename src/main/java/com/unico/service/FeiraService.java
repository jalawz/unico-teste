package com.unico.service;

import com.unico.model.Feira;
import com.unico.repository.FeiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeiraService {

    private final FeiraRepository feiraRepository;

    public List<Feira> buscarFeirasLivres() {
        return feiraRepository.findAll();
    }

    public Feira criarNovaFeira(Feira feira) {
        return feiraRepository.save(feira);
    }
}
