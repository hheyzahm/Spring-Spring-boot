package springFrameworkSpringBoot.S7MockMVC.services;



import springFrameworkSpringBoot.S7MockMVC.Model.BeerMockMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceMockMVC {
    List<BeerMockMVC> listBeers();

    BeerMockMVC getBeerById(UUID id);

    BeerMockMVC saveNewBeer(BeerMockMVC beerMockMVC);

    void updateBeerById(UUID beerId, BeerMockMVC beerMockMVC);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerMockMVC beerMockMVC);
}
