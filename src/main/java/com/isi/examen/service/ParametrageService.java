package com.isi.examen.service;

import com.isi.examen.model.Classe;
import com.isi.examen.model.Sector;
import com.isi.examen.repository.ClasseRepository;
import com.isi.examen.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametrageService {

    @Autowired
    private SectorRepository sectorRepo;

    @Autowired
    private ClasseRepository classeRepo;

    public List<Sector> getAllSectors() {
        return sectorRepo.findAll();
    }

    public List<Classe> getClassesBySectorId(Long id) {
        return classeRepo.findBySectorId(id);
    }
}