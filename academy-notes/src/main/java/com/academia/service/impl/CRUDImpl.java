package com.academia.service.impl;

import com.academia.exception.ModelNotFoundException;
import com.academia.repository.IGenericRepo;
import com.academia.service.ICRUD;

import java.util.List;

/**
 * Clase que implmeenta CRUD generico
 *
 * @param <T>
 * @param <ID>
 */
public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        // validando la existencia un ID
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID no encontrado: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID no encontrado: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID no encontrado: " + id));
    }
}
