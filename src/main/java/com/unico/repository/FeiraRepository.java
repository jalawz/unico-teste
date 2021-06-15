package com.unico.repository;

import com.unico.model.Feira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeiraRepository extends JpaRepository<Feira, Integer> {

    List<Feira> findByDistritoOrRegiao5OrNomeFeiraOrBairro(String distrito, String regiao5, String nomeFeira, String bairro);
}
