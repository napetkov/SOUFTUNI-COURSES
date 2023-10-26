package bg.softuni.bookservice.web;

import bg.softuni.bookservice.model.dto.BookDTO;
import bg.softuni.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksRestController {
    private final BookService bookService;

    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable("id") Long id){
        Optional<BookDTO> bookDTOOptional = bookService.findById(id);

        return bookDTOOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(
            @RequestBody BookDTO bookDTO,
            UriComponentsBuilder uriComponentsBuilder){

        long newBookId = bookService.createBook(bookDTO);

        return ResponseEntity.created(uriComponentsBuilder.path("/api/books/{id}")
                .build(newBookId))
                .build();
    }

}
