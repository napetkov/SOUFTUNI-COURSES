package bg.softuni.modelmapper.repositories;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeNameAndSalaryDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeesNamesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new bg.softuni.modelmapper.entities.dtos.EmployeesNamesDTO" +
             "(e.firstName, e.lastName) from Employee e where e.id = :id")
    EmployeesNamesDTO findNamesById(long id);

    EmployeeNameAndSalaryDTO findFirstNameAndSalaryById(Long id);
}
