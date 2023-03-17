package springFrameworkSpringBoot.SpringMVC.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.SpringMVC.Model.BeerMVC;
import springFrameworkSpringBoot.SpringMVC.Model.BeerStyleMVC;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServiceMVCImpl implements BeerServiceMVC {

    private Map<UUID, BeerMVC> beerMap;

    public BeerServiceMVCImpl() {
        this.beerMap = new HashMap<>();

        BeerMVC beerMVC1 = BeerMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleMVC.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerMVC beerMVC2 = BeerMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleMVC.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerMVC beerMVC3 = BeerMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleMVC.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beerMVC1.getId(), beerMVC1);
        beerMap.put(beerMVC2.getId(), beerMVC2);
        beerMap.put(beerMVC3.getId(), beerMVC3);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerMVC beerMVC) {
        BeerMVC existing = beerMap.get(beerId);

        if (StringUtils.hasText(beerMVC.getBeerName())){
            existing.setBeerName(beerMVC.getBeerName());
        }

        if (beerMVC.getBeerStyle() != null) {
            existing.setBeerStyle(beerMVC.getBeerStyle());
        }

        if (beerMVC.getPrice() != null) {
            existing.setPrice(beerMVC.getPrice());
        }

        if (beerMVC.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beerMVC.getQuantityOnHand());
        }

        if (StringUtils.hasText(beerMVC.getUpc())) {
            existing.setUpc(beerMVC.getUpc());
        }
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void updateBeerById(UUID beerId, BeerMVC beerMVC) {
        BeerMVC existing = beerMap.get(beerId);
        existing.setBeerName(beerMVC.getBeerName());
        existing.setPrice(beerMVC.getPrice());
        existing.setUpc(beerMVC.getUpc());
        existing.setQuantityOnHand(beerMVC.getQuantityOnHand());
    }

    @Override
    public List<BeerMVC> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerMVC getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public BeerMVC saveNewBeer(BeerMVC beerMVC) {

        BeerMVC savedBeerMVC = BeerMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beerMVC.getBeerName())
                .beerStyle(beerMVC.getBeerStyle())
                .quantityOnHand(beerMVC.getQuantityOnHand())
                .upc(beerMVC.getUpc())
                .price(beerMVC.getPrice())
                .build();

        beerMap.put(savedBeerMVC.getId(), savedBeerMVC);

        return savedBeerMVC;
    }
}