package pl.yellowduck.recruiting.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Person {

    @Id
    private long id;
    private String identifier;
    private String name;
    private String surname;
}
