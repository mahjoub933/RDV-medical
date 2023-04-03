package tn.mahjoub.rdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.mahjoub.rdv.model.Users;
@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

    Users findByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);
}
