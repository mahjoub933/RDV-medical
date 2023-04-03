package tn.mahjoub.rdv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseObject implements Serializable {

    private String nom;

    private String prenom;

    private String username;

    private String email;

    private String telephone;

    private Genre genre;

    private String addresse;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @ManyToOne
    private Speciality speciality;

    @Transient
    private Long specialityId;
}
