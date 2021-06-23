package com.unico.controller;

import com.unico.dto.FeiraRequestDTO;
import com.unico.dto.FeiraResponseDTO;
import com.unico.exception.StandardError;
import com.unico.mapper.FeiraMapper;
import com.unico.service.FeiraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feiras")
@RequiredArgsConstructor
public class FeirasController {

    private final FeiraService feiraService;

    @GetMapping
    @ApiOperation(value = "Retorna lista de feiras-livres")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de feiras-livres", response = FeiraResponseDTO.class)
    })
    public ResponseEntity<List<FeiraResponseDTO>> buscarFeirasLivres(@RequestParam(required = false) String filtro) {
        return ResponseEntity.ok(feiraService.buscarFeirasLivres(filtro).stream()
                .map(FeiraMapper::toResponseDto).collect(Collectors.toList()));
    }

    @PostMapping
    @ApiOperation(value = "Cria uma nova feira-livre")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cria nova feira-livre", response = FeiraResponseDTO.class)
    })
    public ResponseEntity<FeiraResponseDTO> criarFeiraLivre(@RequestBody FeiraRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(FeiraMapper.toResponseDto(feiraService.criarNovaFeira(FeiraMapper.toModelRequest(request))));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar uma feira-livre por id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Feira atualizada com sucesso"),
            @ApiResponse(code = 404, message = "Feira não encontrada", response = StandardError.class)
    })
    public ResponseEntity<Void> atualizarFeiraLivre(@RequestBody FeiraRequestDTO requestDTO,
                                                 @PathVariable("id") Integer id) {
        feiraService.atualizarFeira(FeiraMapper.toModelRequest(requestDTO), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remover uma feira-livre por id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Feira removida com sucesso"),
            @ApiResponse(code = 404, message = "Feira não encontrada", response = StandardError.class)
    })
    public ResponseEntity<Void> removerFeiraLivre(@PathVariable("id") Integer id) {
        feiraService.deletarFeira(id);
        return ResponseEntity.noContent().build();
    }
}
