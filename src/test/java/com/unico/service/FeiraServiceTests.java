package com.unico.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unico.model.Feira;
import com.unico.repository.FeiraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FeiraServiceTests {
    
    @InjectMocks
    private FeiraService feiraService;

    @Mock
    private FeiraRepository feiraRepository;

    @Test
    public void buscarFeirasComFiltro() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Feira> feiras = mapper.readValue(getMockFile("feiras-filtro.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, Feira.class));

        when(feiraRepository.findByDistritoOrRegiao5OrNomeFeiraOrBairro(any(), any(), any(), any())).thenReturn(feiras);

        List<Feira> response = feiraService.buscarFeirasLivres("vl mazzei");

        assertThat(response, hasSize(3));
        assertTrue(response.get(0).getBairro().equals("VL MAZZEI"));
    }

    @Test
    public void buscarFeirasSemFiltro() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Feira> feiras = mapper.readValue(getMockFile("feiras-sem-filtro.json"),
                mapper.getTypeFactory().constructCollectionType(List.class, Feira.class));

        when(feiraRepository.findAll()).thenReturn(feiras);

        List<Feira> response = feiraService.buscarFeirasLivres(null);

        assertThat(response, hasSize(880));
    }

    private File getMockFile(String fileName) throws FileNotFoundException {
        return ResourceUtils.getFile(String.format("classpath:mocks/%s", fileName));
    }
}
