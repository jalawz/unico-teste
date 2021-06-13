package com.unico.repository;

import com.unico.model.Feira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeiraRepository extends JpaRepository<Feira, Integer> {
}
