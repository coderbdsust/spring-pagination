package model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String designation;
    private Address homeAddress;
    private Address permanentAddress;
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updated;

}
