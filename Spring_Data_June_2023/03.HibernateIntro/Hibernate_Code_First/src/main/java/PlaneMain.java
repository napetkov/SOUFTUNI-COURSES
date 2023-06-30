import composition.Company;
import composition.Plane;

import javax.persistence.EntityManager;
import java.util.List;

public class PlaneMain {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.creteEntityManager();

        entityManager.getTransaction().begin();


        Company company = new Company("noname");
        Plane plane = new Plane("NikAir2", 250);
        Plane plane2 = new Plane("IvAir2", 255);

        plane.setCompany(company);
        plane2.setCompany(company);

        entityManager.persist(company);
        entityManager.persist(plane);
        entityManager.persist(plane2);




        Company found = entityManager.find(Company.class, 1);

        List<Plane> planes = found.getPlanes();


        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
