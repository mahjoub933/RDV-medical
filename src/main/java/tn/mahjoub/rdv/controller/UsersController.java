package tn.mahjoub.rdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.mahjoub.rdv.model.Users;
import tn.mahjoub.rdv.service.impl.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController implements ControllerGeneric<Users, Long> {

    @Autowired
    private UsersService usersService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<Users> save(@RequestBody Users entity) {
        return new ResponseEntity<>(usersService.save(entity), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update/{id]")
    public ResponseEntity<Users> update(@RequestBody Users entity, @PathVariable("id") Long aLong) {
        return new ResponseEntity<>(usersService.update(entity, aLong), HttpStatus.OK);
    }

    @Override
    @GetMapping("/getone/{id}")
    public ResponseEntity<Users> findById(@PathVariable("id") Long aLong) {
        return new ResponseEntity<>(usersService.findById(aLong), HttpStatus.OK);
    }

    @Override
    @GetMapping("/getall")
    public ResponseEntity<List<Users>> findAll() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long aLong) {
        return new ResponseEntity<>(usersService.delete(aLong), HttpStatus.OK);
    }
}
