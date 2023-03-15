package springFrameworkSpringBoot.services;

import springFrameworkSpringBoot.domain.Author;

/**
 * @Created 15 03 2023 - 12:35 PM
 * @Author Hazeem Hassan
 */
public interface AuthorService {
    Iterable<Author> findAllAuthors();
}
