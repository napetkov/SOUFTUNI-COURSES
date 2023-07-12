package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeNameAndSalaryDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeesNamesDTO;
import bg.softuni.modelmapper.repositories.AddressRepository;
import bg.softuni.modelmapper.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employRepository;
    private AddressRepository addressRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employRepository, AddressRepository addressRepository, ModelMapper mapper) {
        this.employRepository = employRepository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employDTO) {

        Employee employee = mapper.map(employDTO, Employee.class);

        Optional<Address> address = this.addressRepository.findByCountryAndCity(employDTO.getAddress().getCountry(),
                employDTO.getAddress().getCity());

        address.ifPresent(employee::setAddress);

        return employRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {

        return this.employRepository.findAll()
                .stream().map(e -> mapper.map(e,EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeesNamesDTO findNamesById(long id) {
        return employRepository.findNamesById(id);
    }

    @Override
    public EmployeeNameAndSalaryDTO findNameAndSalaryById(long id) {
        return employRepository.findFirstNameAndSalaryById(id);
    }
}
