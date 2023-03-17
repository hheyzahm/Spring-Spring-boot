package springFrameworkSpringBoot.S7MockMVC.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerMVC;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerControllerMVC {
    private final BeerServiceMVC beerServiceMVC;

    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId")UUID beerId, @RequestBody BeerMVC beerMVC){

        beerServiceMVC.patchBeerById(beerId, beerMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

        beerServiceMVC.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateById(@PathVariable("beerId")UUID beerId, @RequestBody BeerMVC beerMVC){

        beerServiceMVC.updateBeerById(beerId, beerMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody BeerMVC beerMVC){

        BeerMVC savedBeerMVC = beerServiceMVC.saveNewBeer(beerMVC);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeerMVC.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BeerMVC> listBeers(){
        return beerServiceMVC.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public BeerMVC getBeerById(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerServiceMVC.getBeerById(beerId);
    }

}