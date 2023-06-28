import entities.Address;
import entities.Town;
import javax.persistence.EntityManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressesWithEmployeeCount {
    public static final String PRINT_FORMAT = "%s, %s - %d employees\n";

    public static void main(String[] args) {

        Utils.createEntityManager()
                .createQuery("FROM Address ORDER BY employees.size desc", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(Address::printFormatAddressesWithEmployeeCount);


    }
}
