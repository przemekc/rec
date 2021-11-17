package pl.yellowduck.recruiting.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private long id;
    private String name;
    private Double price;
}
