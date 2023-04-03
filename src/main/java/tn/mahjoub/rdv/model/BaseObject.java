package tn.mahjoub.rdv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "base_generator")
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp createAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp updateAt;
}
