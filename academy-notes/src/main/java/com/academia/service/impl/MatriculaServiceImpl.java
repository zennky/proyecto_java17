package com.academia.service.impl;

import com.academia.model.Matricula;
import com.academia.repository.IGenericRepo;
import com.academia.repository.IMatriculaRepo;
import com.academia.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa los CRUD's al entity @{@link Matricula}
 */
@Service
@RequiredArgsConstructor // esta anotacion reemplaza la anotacion @Autowired
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return this.repo;
    }
}
