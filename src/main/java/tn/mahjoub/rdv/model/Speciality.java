package tn.mahjoub.rdv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speciality extends BaseObject implements Serializable {
    private String name;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.PERSIST)
    private List<Users> users;
}
