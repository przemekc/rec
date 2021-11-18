package pl.yellowduck.recruiting.offer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class H2OfferRepository {

  public Offer save(Offer entity) {
    return null;
  }

  public List<Offer> findAll() {
    return List.of();
  }

  public Offer findById(Integer id) {
    return null;
  }
}
