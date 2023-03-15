package springFrameworkSpringBoot.Chapter2.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.Chapter2.domain.Author;
import springFrameworkSpringBoot.Chapter2.repositories.AuthorRepository;

/**
 * @Created 15 03 2023 - 12:35 PM
 * @Author Hazeem Hassan
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}
