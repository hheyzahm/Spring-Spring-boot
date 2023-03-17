package springFrameworkSpringBoot.S6SpringMVC.services;



import springFrameworkSpringBoot.S6SpringMVC.Model.BeerSpringMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceSpringMVC {
    List<BeerSpringMVC> listBeers();

    BeerSpringMVC getBeerById(UUID id);

    BeerSpringMVC saveNewBeer(BeerSpringMVC beerSpringMVC);

    void updateBeerById(UUID beerId, BeerSpringMVC beerSpringMVC);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerSpringMVC beerSpringMVC);
}
