package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeNameAndSalaryDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeesNamesDTO;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employDTO);

    List<EmployeeDTO> findAll();

    EmployeesNamesDTO findNamesById(long id);

    EmployeeNameAndSalaryDTO findNameAndSalaryById(long id);
}
