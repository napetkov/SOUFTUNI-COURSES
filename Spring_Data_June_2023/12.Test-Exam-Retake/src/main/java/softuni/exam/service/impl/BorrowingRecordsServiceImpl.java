package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordWrapperImportDto;
import softuni.exam.models.dto.ExportRecordsDto;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static String BORROWING_RECORDS_FILE_PATH = "src/main/resources/files/xml/borrowing-records.xml";
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;


    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_FILE_PATH));
    }

    @Override
    public String importBorrowingRecords() throws  JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(BORROWING_RECORDS_FILE_PATH, BorrowingRecordWrapperImportDto.class)
                .getBorrowingRecords()
                .stream().filter(borrowingRecordImportDto -> {
                    boolean isValid = validationUtils.isValid(borrowingRecordImportDto);

                    if(this.libraryMemberRepository.findById(borrowingRecordImportDto.getMember().getId()).isEmpty()
                         || this.bookRepository.findFirstByTitle(borrowingRecordImportDto.getBook().getTitle()).isEmpty()
                    )
                        isValid = false;

                    stringBuilder.append(isValid
                    ?String.format(SUCCESSFUL_FORMAT,BORROWING_RECORD,borrowingRecordImportDto.getBook().getTitle()
                    ,borrowingRecordImportDto.getBorrowDate())
                            :String.format(INVALID_FORMAT,BORROWING_RECORD));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(recordToSave -> {
                    BorrowingRecord record = modelMapper.map(recordToSave, BorrowingRecord.class);

                    record.setBook(this.bookRepository.findFirstByTitle(recordToSave.getBook().getTitle()).get());
                    record.setLibraryMember(this.libraryMemberRepository.findById(recordToSave.getMember().getId()).get());

                    return record;
                })
                .forEach(this.borrowingRecordRepository::save);

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder stringBuilder = new StringBuilder();

        List<BorrowingRecord> records = this.borrowingRecordRepository
                .findAllByBookGenreAndBorrowDateBeforeOrderByBorrowDateDesc
                        (Genre.SCIENCE_FICTION, LocalDate.of(2021, 9, 10));

        records.forEach(record -> stringBuilder.append(String.format(
                "Book title: %s%n*Book author: %s%n**Date borrowed: %s%n***Borrowed by: %s %s%n",
                record.getBook().getTitle(),
                record.getBook().getAuthor(),
                record.getBorrowDate(),
                record.getLibraryMember().getFirstName(),
                record.getLibraryMember().getLastName()
        )));


        return stringBuilder.toString().trim();
    }
}
