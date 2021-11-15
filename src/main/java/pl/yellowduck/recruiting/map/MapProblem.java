package pl.yellowduck.recruiting.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapProblem {

  public static void main(String[] args) {
    Map<Id, String> map = new HashMap<>();
    map.put(Id.of(1, 1), "customer1");
    map.put(Id.of(2, 1), "customer2");

    String s = map.get(Id.of(1, 1));
    System.out.println(s);
  }
}

class Id {
  private int customer;
  private int id;

  public Id(int customer, int id) {
    this.customer = customer;
    this.id = id;
  }

  public static Id of(int customer, int id) {
    return new Id(customer, id);
  }

  public int getCustomer() {
    return customer;
  }

  public int getId() {
    return id;
  }

  public void setCustomer(int customer) {
    this.customer = customer;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Id id1 = (Id) o;
    return id == id1.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}