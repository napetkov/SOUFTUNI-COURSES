package bg.softuni.bookservice.service.impl;

import bg.softuni.bookservice.model.dto.AuthorDTO;
import bg.softuni.bookservice.model.dto.BookDTO;
import bg.softuni.bookservice.model.entity.AuthorEntity;
import bg.softuni.bookservice.model.entity.BookEntity;
import bg.softuni.bookservice.repository.AuthorRepository;
import bg.softuni.bookservice.repository.BookRepository;
import bg.softuni.bookservice.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookServiceImpl::mapBookToDTO)
                .toList();
    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        return bookRepository.findById(id).map(BookServiceImpl::mapBookToDTO);
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        Optional<AuthorEntity> authorOptional = authorRepository.findByName(bookDTO.getAuthor().getName());
        AuthorEntity author = new AuthorEntity();
        if(authorOptional.isEmpty()){
            author.setName(bookDTO.getAuthor().getName());
           author =  authorRepository.save(author);
        }else {
            author = authorOptional.get();
        }

        BookEntity newBook = new BookEntity()
                .setAuthor(author)
                .setIsbn(bookDTO.getIsbn())
                .setTitle(bookDTO.getTitle());

        newBook = bookRepository.save(newBook);

        return newBook.getId();
    }


    private static BookDTO mapBookToDTO(BookEntity book){
        AuthorDTO authorDTO = new AuthorDTO()
                .setName(book.getAuthor().getName());

        return new BookDTO()
                .setId(book.getId())
                .setTitle(book.getTitle())
                .setAuthor(authorDTO)
                .setIsbn(book.getIsbn());
    }
}
