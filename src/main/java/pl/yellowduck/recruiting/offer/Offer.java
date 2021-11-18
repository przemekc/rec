package pl.yellowduck.recruiting.offer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity
public class Offer {

  @Id
  private Integer id;

  private String name;

  private Date created;

  private Date activeTo;

  @ManyToOne
  private Product product;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Offer offer = (Offer) o;
    return Objects.equals(id, offer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, created);
  }

  public void activate(Date endDate) {
    this.activeTo = endDate;
  }
}
