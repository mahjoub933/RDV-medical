package tn.mahjoub.rdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.mahjoub.rdv.model.Speciality;

@Repository
public interface SpecialityRepo extends JpaRepository<Speciality, Long> {
}
