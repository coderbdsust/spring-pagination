package model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String houseNo;
    private String roadNo;
    private String policeStation;
    private String city;
    private String state;
    private String mobileNo;
    private String email;
    @OneToMany
    private Collection<User> usersById;

}