package springFrameworkSpringBoot.services;

import springFrameworkSpringBoot.domain.Book;

/**
 * @Created 15 03 2023 - 11:04 AM
 * @Author Hazeem Hassan
 */
public interface BookService {
    Iterable<Book> findAll();

}
