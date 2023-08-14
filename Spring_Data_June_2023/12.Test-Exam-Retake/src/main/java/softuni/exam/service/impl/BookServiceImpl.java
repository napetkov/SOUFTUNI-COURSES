package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class BookServiceImpl implements BookService {
    private final String BOOKS_FILE_PATH = "src/main/resources/files/json/books.json";

    private final BookRepository bookRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;


    public BookServiceImpl(BookRepository bookRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_FILE_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readBooksFromFile(), BookImportDto[].class))
                .filter(bookImportDto -> {
                    boolean isValid = validationUtils.isValid(bookImportDto);

                    if (this.bookRepository.findFirstByTitle(bookImportDto.getTitle()).isPresent()) isValid = false;

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, BOOK, bookImportDto.getAuthor(), bookImportDto.getTitle())
                            : String.format(INVALID_FORMAT, BOOK));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(bookToSave -> modelMapper.map(bookToSave, Book.class))
                .forEach(this.bookRepository::save);

        return stringBuilder.toString().trim();
    }
}
