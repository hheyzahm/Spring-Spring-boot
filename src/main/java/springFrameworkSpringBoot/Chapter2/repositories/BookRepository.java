package springFrameworkSpringBoot.Chapter2.repositories;

import org.springframework.data.repository.CrudRepository;
import springFrameworkSpringBoot.Chapter2.domain.Book;


public interface BookRepository extends CrudRepository<Book,Long> {
}
