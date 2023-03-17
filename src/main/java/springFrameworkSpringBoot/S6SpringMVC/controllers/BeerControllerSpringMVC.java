package springFrameworkSpringBoot.S6SpringMVC.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S6SpringMVC.Model.BeerSpringMVC;
import springFrameworkSpringBoot.S6SpringMVC.services.BeerServiceSpringMVC;


import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/SpringMVC/api/v1/beer/")
public class BeerControllerSpringMVC {
    private final BeerServiceSpringMVC beerServiceSpringMVC;

    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchByIdSpringMVC(@PathVariable("beerId")UUID beerId, @RequestBody BeerSpringMVC beerSpringMVC){

        beerServiceSpringMVC.patchBeerById(beerId, beerSpringMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteByIdSpringMVC(@PathVariable("beerId") UUID beerId){

        beerServiceSpringMVC.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateByIdSpringMVC(@PathVariable("beerId")UUID beerId, @RequestBody BeerSpringMVC beerSpringMVC){

        beerServiceSpringMVC.updateBeerById(beerId, beerSpringMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePostSpringMVC(@RequestBody BeerSpringMVC beerSpringMVC){

        BeerSpringMVC savedBeerSpringMVC = beerServiceSpringMVC.saveNewBeer(beerSpringMVC);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeerSpringMVC.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BeerSpringMVC> listBeersSpringMVC(){
        return beerServiceSpringMVC.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public BeerSpringMVC getBeerByIdSpringMVC(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerServiceSpringMVC.getBeerById(beerId);
    }

}