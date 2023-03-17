package springFrameworkSpringBoot.S7MockMVC.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerMockMVC;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerStyleMockMVC;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServiceMockMVCImpl implements BeerServiceMockMVC {

    private Map<UUID, BeerMockMVC> beerMap;

    public BeerServiceMockMVCImpl() {
        this.beerMap = new HashMap<>();

        BeerMockMVC beerMockMVC1 = BeerMockMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleMockMVC.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerMockMVC beerMockMVC2 = BeerMockMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleMockMVC.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerMockMVC beerMockMVC3 = BeerMockMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleMockMVC.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beerMockMVC1.getId(), beerMockMVC1);
        beerMap.put(beerMockMVC2.getId(), beerMockMVC2);
        beerMap.put(beerMockMVC3.getId(), beerMockMVC3);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerMockMVC beerMockMVC) {
        BeerMockMVC existing = beerMap.get(beerId);

        if (StringUtils.hasText(beerMockMVC.getBeerName())){
            existing.setBeerName(beerMockMVC.getBeerName());
        }

        if (beerMockMVC.getBeerStyle() != null) {
            existing.setBeerStyle(beerMockMVC.getBeerStyle());
        }

        if (beerMockMVC.getPrice() != null) {
            existing.setPrice(beerMockMVC.getPrice());
        }

        if (beerMockMVC.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beerMockMVC.getQuantityOnHand());
        }

        if (StringUtils.hasText(beerMockMVC.getUpc())) {
            existing.setUpc(beerMockMVC.getUpc());
        }
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void updateBeerById(UUID beerId, BeerMockMVC beerMockMVC) {
        BeerMockMVC existing = beerMap.get(beerId);
        existing.setBeerName(beerMockMVC.getBeerName());
        existing.setPrice(beerMockMVC.getPrice());
        existing.setUpc(beerMockMVC.getUpc());
        existing.setQuantityOnHand(beerMockMVC.getQuantityOnHand());
    }

    @Override
    public List<BeerMockMVC> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerMockMVC getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public BeerMockMVC saveNewBeer(BeerMockMVC beerMockMVC) {

        BeerMockMVC savedBeerMockMVC = BeerMockMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beerMockMVC.getBeerName())
                .beerStyle(beerMockMVC.getBeerStyle())
                .quantityOnHand(beerMockMVC.getQuantityOnHand())
                .upc(beerMockMVC.getUpc())
                .price(beerMockMVC.getPrice())
                .build();

        beerMap.put(savedBeerMockMVC.getId(), savedBeerMockMVC);

        return savedBeerMockMVC;
    }
}