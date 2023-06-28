import entities.Address;
import entities.Employee;
import entities.Town;
import javax.persistence.EntityManager;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AddingANewAddressAndUpdatingTheEmployee {
    public static final String NEW_ADDRESS_STREET = "Vitoshka 15";

    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);
        final String employeeLastName = scanner.nextLine();

        entityManager.getTransaction().begin();

        final Random random = new Random();
        final int townId = random.nextInt(32 + 1 - 1) + 1;

        final Town randomTown = entityManager.createQuery("FROM Town where id = : townId", Town.class)
                .setParameter("townId", townId)
                .getSingleResult();
        final List<Employee> allEmployeesWithGivenLastName = entityManager.createQuery("FROM Employee where lastName= :lastName", Employee.class)
                .setParameter("lastName", employeeLastName)
                .getResultList();

        Address newAddress = new Address();
        newAddress.setText(NEW_ADDRESS_STREET);
        newAddress.setTown(randomTown);

        entityManager.persist(newAddress);


        for (Employee e : allEmployeesWithGivenLastName) {
            e.setAddress(newAddress);
        }

        entityManager.flush();
        entityManager.getTransaction().commit();
        scanner.close();
    }
}
