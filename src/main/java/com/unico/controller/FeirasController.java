package com.unico.controller;

import com.unico.dto.FeiraRequestDTO;
import com.unico.mapper.FeiraMapper;
import com.unico.model.Feira;
import com.unico.service.FeiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feiras")
@RequiredArgsConstructor
public class FeirasController {

    private final FeiraService feiraService;

    @GetMapping
    public ResponseEntity<List<Feira>> buscarFeirasLivres(@RequestParam(required = false) String filtro) {
        return ResponseEntity.ok(feiraService.buscarFeirasLivres(filtro));
    }

    @PostMapping
    public ResponseEntity<?> criarFeiraLivre(@RequestBody FeiraRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(feiraService.criarNovaFeira(FeiraMapper.toModelRequest(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFeiraLivre(@RequestBody FeiraRequestDTO requestDTO,
                                                 @PathVariable("id") Integer id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerFeiraLivre(@PathVariable("id") Integer id) {
        return null;
    }
}
