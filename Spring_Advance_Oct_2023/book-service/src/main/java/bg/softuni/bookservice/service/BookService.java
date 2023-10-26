package bg.softuni.bookservice.service;

import bg.softuni.bookservice.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> findById(Long id);

    void deleteBookById(Long id);

    Long createBook(BookDTO bookDTO);
}
