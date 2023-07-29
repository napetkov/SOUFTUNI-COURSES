package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerImportDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static exam.model.Constants.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    private final Gson gson;
    private final ValidationUtils validationUtils;

    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<CustomerImportDto> customers = Arrays.stream(gson.fromJson(readCustomersFileContent(), CustomerImportDto[].class)).toList();

        for (CustomerImportDto customer : customers) {
            stringBuilder.append(System.lineSeparator());

            Optional<Town> town = this.townRepository.findFirstByName(customer.getTown().getName());

            if (this.customerRepository.findFirstByEmail(customer.getEmail()).isPresent()
            ||town.isEmpty()
            || !validationUtils.isValid(customer)) {
                stringBuilder.append(String.format(INVALID_FORMAT,CUSTOMER));

                continue;
            }

            Customer customerToSave = modelMapper.map(customer, Customer.class);

            customerToSave.setTown(town.get());

            this.customerRepository.save(customerToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT,
                    CUSTOMER,
                    customer.getFirstName() + " " + customer.getLastName(),
                    "- " + customer.getEmail()));

        }


        return stringBuilder.toString().trim();
    }
}
