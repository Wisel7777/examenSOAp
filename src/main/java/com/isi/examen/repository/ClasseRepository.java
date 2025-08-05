package com.isi.examen.repository;

import com.isi.examen.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
    List<Classe> findBySectorId(Long sectorId);
}
