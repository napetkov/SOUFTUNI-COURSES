import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    private static final String PRINT_FORMAT_DELETED_TOWN = "%d address in %s deleted";

    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();
        String givenTown = new Scanner(System.in).nextLine();

//        try {
        entityManager.getTransaction().begin();

        final Town townForDelete = entityManager.createQuery("FROM Town WHERE name = : givenTown", Town.class)
                .setParameter("givenTown", givenTown)
                .getSingleResult();

        setEmployeeAddressToNull(entityManager, givenTown);

        final List<Address> addressesOfTownForDelete = entityManager.createQuery("FROM Address where id = : townId", Address.class)
                .setParameter("townId", townForDelete.getId())
                .getResultList();

        final int sizeOfTownForDelete = addressesOfTownForDelete.size();

        addressesOfTownForDelete.forEach(entityManager::remove);

        entityManager.remove(townForDelete);

        System.out.printf(PRINT_FORMAT_DELETED_TOWN, sizeOfTownForDelete, townForDelete.getName());
        entityManager.getTransaction().commit();
//        }catch (Exception e){
//            System.out.println("There is no commitment and now deleted town."+
//                    System.lineSeparator()
//                    + e.getMessage());
//        }

        entityManager.close();

    }

    private static void setEmployeeAddressToNull(EntityManager entityManager, String townName) {
        List<Employee> employees = entityManager.createQuery("FROM Employee where Employee.address.town.name= : givenTown", Employee.class)
                .setParameter("givenTown", "townName")
                .getResultList();

        employees.forEach(employee -> {
            employee.setAddress(null);

            entityManager.persist(employee);
        });

        entityManager.flush();
    }
}
