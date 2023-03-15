package springFrameworkSpringBoot.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.domain.Author;
import springFrameworkSpringBoot.repositories.AuthorRepository;

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
