package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMembersImportDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {
    private final String LIBRARY_MEMBERS_FILE_PATH = "src/main/resources/files/json/library-members.json";

    private final LibraryMemberRepository libraryMemberRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_FILE_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readLibraryMembersFileContent(), LibraryMembersImportDto[].class))
                .filter(libraryMembersImportDto -> {
                    boolean isValid = validationUtils.isValid(libraryMembersImportDto);

                    if (this.libraryMemberRepository.findFirstByPhoneNumber(libraryMembersImportDto.getPhoneNumber()).isPresent())
                        isValid = false;

                    stringBuilder.append(isValid
                            ? String.format(SUCCESSFUL_FORMAT, LIBRARY_MEMBER, libraryMembersImportDto.getFirstName(), libraryMembersImportDto.getLastName())
                            : String.format(INVALID_FORMAT, LIBRARY_MEMBER));

                    stringBuilder.append(System.lineSeparator());

                    return isValid;
                })
                .map(memberToSave -> modelMapper.map(memberToSave, LibraryMember.class))
                .forEach(this.libraryMemberRepository::save);

        return stringBuilder.toString().trim();
    }
}
