package pl.yellowduck.recruiting.persistence;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Invoice {

    @Id
    private long id;
    private String number;
    private LocalDate creteDate;
    @OneToMany
    @Lazy
    private List<Product> products;
    @ManyToOne
    private Person creator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    @Transient
    public String getFullNumber() {
        return String.format("%s/%s/%s",
                creteDate.getMonth(),
                number,
                creator.getIdentifier());
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Product> getProducts() {
        return products;
    }

    protected void setProducts(List<Product> products) {
        this.products = products;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && Objects.equals(number, invoice.number) && Objects.equals(products, invoice.products) && Objects.equals(creator, invoice.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, products, creator);
    }
}
