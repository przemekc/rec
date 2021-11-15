package pl.yellowduck.recruiting.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ModuleDescriptor;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

  private final H2OfferRepository h2OfferRepository;
  private final MongoOfferRepository mongoOfferRepository;
  private Date endDate;

  @Autowired
  public OfferService(H2OfferRepository h2OfferRepository,
                      MongoOfferRepository mongoOfferRepository) {
    this.h2OfferRepository = h2OfferRepository;
    this.mongoOfferRepository = mongoOfferRepository;
  }

  @Transactional
  public void create(String name, Date endDate) {
    this.endDate = endDate;
    Offer offer = createNewOffer(name);

    if (isProduction()) {
      this.mongoOfferRepository.save(offer);
    } else {
      this.h2OfferRepository.save(offer);
    }
    System.out.println("Offered saved " + this.endDate);
  }

  private Offer createNewOffer(String name) {
    Offer offer = new Offer();
    offer.setCreated(this.endDate);
    offer.setName(name);
    return offer;
  }

  private void changeCategory(Integer id, String name) {
    System.out.println(this.endDate);
    findOffer(id).getProduct().getCategory().setName(name);
  }

  private Offer findOffer(Integer id) {
    if (isProduction()) {
      return this.mongoOfferRepository.findById(id);
    } else {
      return this.h2OfferRepository.findById(id);
    }
  }

  public List<Offer> search(String searchPhrase) {
    List<Offer> offers = isProduction() ?
        mongoOfferRepository.findAll() : h2OfferRepository.findAll();

    return offers.stream()
        .filter(o -> o.getName().toUpperCase().contains(searchPhrase))
        .collect(Collectors.toList());
  }

  private boolean isProduction() {
    return false;
  }

}
