package com.academia.service.impl;

import com.academia.model.Curso;
import com.academia.repository.ICursoRepo;
import com.academia.repository.IGenericRepo;
import com.academia.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa los CRUD's al entity @{@link Curso}
 */
@Service
@RequiredArgsConstructor // este reemplaza a la anotacion @Autowired
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return this.repo;
    }
}
