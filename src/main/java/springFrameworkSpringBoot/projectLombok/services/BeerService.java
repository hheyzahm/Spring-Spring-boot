package springFrameworkSpringBoot.projectLombok.services;


import springFrameworkSpringBoot.projectLombok.Model.Beer;

import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerService {
    Beer getBeerByID(UUID uuidID);
}
