package tn.mahjoub.rdv.service;


import tn.mahjoub.rdv.model.BaseObject;

import java.util.List;

public interface GenericService<T extends BaseObject, ID> {

    T save(T entity);

    T update(T entity, ID id);

    boolean delete(ID id);

    T findById(ID id);

    List<T> findAll();

}
