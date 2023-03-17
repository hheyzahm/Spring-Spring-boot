package springFrameworkSpringBoot.projectLombok.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.projectLombok.Model.Beer;
import springFrameworkSpringBoot.projectLombok.services.BeerService;

import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerByID(UUID uuid) {
        log.debug("Get Beer by Id - in Controller.  ");
        return beerService.getBeerByID(uuid);
    }
}