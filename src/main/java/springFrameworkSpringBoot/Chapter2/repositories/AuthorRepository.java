package springFrameworkSpringBoot.Chapter2.repositories;

import org.springframework.data.repository.CrudRepository;
import springFrameworkSpringBoot.Chapter2.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
