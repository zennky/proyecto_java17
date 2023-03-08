package com.academia.service.impl;

import com.academia.model.Estudiante;
import com.academia.repository.IEstudianteRepo;
import com.academia.repository.IGenericRepo;
import com.academia.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa los CRUD's al entity @{@link Estudiante}
 */
@Service
@RequiredArgsConstructor // esta anotacion reemplaza a @Autowired
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;
    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return this.repo;
    }
}
