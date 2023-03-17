package springFrameworkSpringBoot.SpringMVC.services;



import springFrameworkSpringBoot.SpringMVC.Model.BeerMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceMVC {
    List<BeerMVC> listBeers();

    BeerMVC getBeerById(UUID id);

    BeerMVC saveNewBeer(BeerMVC beerMVC);

    void updateBeerById(UUID beerId, BeerMVC beerMVC);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerMVC beerMVC);
}
