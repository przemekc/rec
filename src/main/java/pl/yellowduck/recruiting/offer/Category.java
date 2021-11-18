package pl.yellowduck.recruiting.offer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

  @Id
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
