package springFrameworkSpringBoot.Chapter2.repositories;

import org.springframework.data.repository.CrudRepository;
import springFrameworkSpringBoot.Chapter2.domain.Publisher;

/**
 * @Created 14  03 2023 - 1:07 PM
 * @Author Hazeem Hassan
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
