package tn.mahjoub.rdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.mahjoub.rdv.model.Speciality;
import tn.mahjoub.rdv.service.impl.SpecialityService;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController implements ControllerGeneric<Speciality, Long> {

    @Autowired
    private SpecialityService specialityService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<Speciality> save(@RequestBody Speciality entity) {
        return new ResponseEntity<>(specialityService.save(entity), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<Speciality> update(@RequestBody Speciality entity, @PathVariable("id") Long aLong) {
        return new ResponseEntity<>(specialityService.update(entity, aLong), HttpStatus.OK);
    }

    @Override
    @GetMapping("/getone")
    public ResponseEntity<Speciality> findById(@PathVariable("id") Long aLong) {
        return new ResponseEntity<>(specialityService.findById(aLong), HttpStatus.OK);
    }

    @Override
    @GetMapping("/getall")
    public ResponseEntity<List<Speciality>> findAll() {
        return new ResponseEntity<>(specialityService.findAll(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long aLong) {
        return new ResponseEntity<>(specialityService.delete(aLong), HttpStatus.OK);
    }
}
