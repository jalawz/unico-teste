package com.unico.controller;

import com.unico.dto.FeiraRequestDTO;
import com.unico.mapper.FeiraMapper;
import com.unico.model.Feira;
import com.unico.service.FeiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feiras")
@RequiredArgsConstructor
public class FeirasController {

    private final FeiraService feiraService;

    @GetMapping
    public ResponseEntity<List<Feira>> buscarFeirasLivres() {
        return ResponseEntity.ok(feiraService.buscarFeirasLivres());
    }

    @PostMapping
    public ResponseEntity<?> criarFeiraLivre(@RequestBody FeiraRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(feiraService.criarNovaFeira(FeiraMapper.toModelRequest(request)));
    }
}
