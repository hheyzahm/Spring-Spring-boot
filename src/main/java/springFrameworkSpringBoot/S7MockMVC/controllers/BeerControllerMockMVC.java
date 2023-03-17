package springFrameworkSpringBoot.S7MockMVC.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerMockMVC;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceMockMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/MockMVC/beer/")
public class BeerControllerMockMVC {
    private final BeerServiceMockMVC beerServiceMockMVC;

    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchByIdMockMVC(@PathVariable("beerId")UUID beerId, @RequestBody BeerMockMVC beerMockMVC){

        beerServiceMockMVC.patchBeerById(beerId, beerMockMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteByIdMockMVC(@PathVariable("beerId") UUID beerId){

        beerServiceMockMVC.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateByIdMockMVC(@PathVariable("beerId")UUID beerId, @RequestBody BeerMockMVC beerMockMVC){

        beerServiceMockMVC.updateBeerById(beerId, beerMockMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePostMockMVC(@RequestBody BeerMockMVC beerMockMVC){

        BeerMockMVC savedBeerMockMVC = beerServiceMockMVC.saveNewBeer(beerMockMVC);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeerMockMVC.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BeerMockMVC> listBeersMockMVC(){
        return beerServiceMockMVC.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public BeerMockMVC getBeerByIdMockMVC(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerServiceMockMVC.getBeerById(beerId);
    }

}