package springFrameworkSpringBoot.S6SpringMVC.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S6SpringMVC.Model.BeerSpringMVC;
import springFrameworkSpringBoot.S6SpringMVC.Model.BeerStyleSpringMVC;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServiceSpringMVCImpl implements BeerServiceSpringMVC {

    private Map<UUID, BeerSpringMVC> beerMap;

    public BeerServiceSpringMVCImpl() {
        this.beerMap = new HashMap<>();

        BeerSpringMVC beerSpringMVC1 = BeerSpringMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleSpringMVC.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerSpringMVC beerSpringMVC2 = BeerSpringMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleSpringMVC.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerSpringMVC beerSpringMVC3 = BeerSpringMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleSpringMVC.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beerSpringMVC1.getId(), beerSpringMVC1);
        beerMap.put(beerSpringMVC2.getId(), beerSpringMVC2);
        beerMap.put(beerSpringMVC3.getId(), beerSpringMVC3);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerSpringMVC beerSpringMVC) {
        BeerSpringMVC existing = beerMap.get(beerId);

        if (StringUtils.hasText(beerSpringMVC.getBeerName())){
            existing.setBeerName(beerSpringMVC.getBeerName());
        }

        if (beerSpringMVC.getBeerStyle() != null) {
            existing.setBeerStyle(beerSpringMVC.getBeerStyle());
        }

        if (beerSpringMVC.getPrice() != null) {
            existing.setPrice(beerSpringMVC.getPrice());
        }

        if (beerSpringMVC.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beerSpringMVC.getQuantityOnHand());
        }

        if (StringUtils.hasText(beerSpringMVC.getUpc())) {
            existing.setUpc(beerSpringMVC.getUpc());
        }
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void updateBeerById(UUID beerId, BeerSpringMVC beerSpringMVC) {
        BeerSpringMVC existing = beerMap.get(beerId);
        existing.setBeerName(beerSpringMVC.getBeerName());
        existing.setPrice(beerSpringMVC.getPrice());
        existing.setUpc(beerSpringMVC.getUpc());
        existing.setQuantityOnHand(beerSpringMVC.getQuantityOnHand());
    }

    @Override
    public List<BeerSpringMVC> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerSpringMVC getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public BeerSpringMVC saveNewBeer(BeerSpringMVC beerSpringMVC) {

        BeerSpringMVC savedBeerSpringMVC = BeerSpringMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beerSpringMVC.getBeerName())
                .beerStyle(beerSpringMVC.getBeerStyle())
                .quantityOnHand(beerSpringMVC.getQuantityOnHand())
                .upc(beerSpringMVC.getUpc())
                .price(beerSpringMVC.getPrice())
                .build();

        beerMap.put(savedBeerSpringMVC.getId(), savedBeerSpringMVC);

        return savedBeerSpringMVC;
    }
}