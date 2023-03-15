package springFrameworkSpringBoot.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.domain.Book;
import springFrameworkSpringBoot.repositories.BookRepository;

/**
 * @Created 15 03 2023 - 11:06 AM
 * @Author Hazeem Hassan
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
