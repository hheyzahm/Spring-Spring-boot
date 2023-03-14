package springFrameworkSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import springFrameworkSpringBoot.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
