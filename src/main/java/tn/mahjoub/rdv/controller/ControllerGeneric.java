package tn.mahjoub.rdv.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.mahjoub.rdv.model.BaseObject;

import java.util.List;

public interface ControllerGeneric<T extends BaseObject, ID> {

    ResponseEntity<T> save(@RequestBody T entity);

    ResponseEntity<T> update(@RequestBody T entity,@PathVariable ID id);

    ResponseEntity<T> findById(@PathVariable ID id);

    ResponseEntity<List<T>> findAll();

    ResponseEntity<Boolean> delete(@PathVariable ID id);


}
