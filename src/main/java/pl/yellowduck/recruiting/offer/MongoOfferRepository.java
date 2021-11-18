package pl.yellowduck.recruiting.offer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoOfferRepository {

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
