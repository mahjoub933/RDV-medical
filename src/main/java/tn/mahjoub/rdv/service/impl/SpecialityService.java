package tn.mahjoub.rdv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.mahjoub.rdv.exception.BadRequestException;
import tn.mahjoub.rdv.exception.NotFoundException;
import tn.mahjoub.rdv.repository.SpecialityRepo;
import tn.mahjoub.rdv.model.Speciality;
import tn.mahjoub.rdv.service.GenericService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SpecialityService implements GenericService<Speciality, Long> {

    @Autowired
    private SpecialityRepo specialityRepo;

    @Override
    public Speciality save(Speciality entity) {
        try {
            return specialityRepo.save(entity);
        } catch (Exception ex) {
            throw new BadRequestException("Error add Speciality. " + ex.getMessage());
        }
    }

    @Override
    public Speciality update(Speciality entity, Long aLong) {
        try {
            return specialityRepo.save(entity);
        } catch (Exception ex) {
            throw new BadRequestException("Error Update Speciality. " + ex.getMessage());
        }
    }

    @Override
    public boolean delete(Long aLong) {
        try {
            specialityRepo.deleteById(aLong);
            return true;
        } catch (Exception e) {
            throw new NotFoundException("Speciality Not Found.");
        }
    }

    @Override
    public Speciality findById(Long aLong) {
        try {
            return specialityRepo.findById(aLong).get();
        } catch (NoSuchElementException e) {
            throw new NotFoundException(String.format("Speciality { id: %s } Not Found. ", aLong));
        }
    }

    @Override
    public List<Speciality> findAll() {
        return specialityRepo.findAll();
    }
}
