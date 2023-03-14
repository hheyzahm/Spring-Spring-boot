package springFrameworkSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import springFrameworkSpringBoot.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
