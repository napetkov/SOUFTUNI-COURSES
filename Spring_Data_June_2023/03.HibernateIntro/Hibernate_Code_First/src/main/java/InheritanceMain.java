import inheritance.Bike;
import inheritance.Car;
import inheritance.Truck;

import javax.persistence.EntityManager;

public class InheritanceMain {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.creteEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new Bike());
        entityManager.persist(new Car());
        entityManager.persist(new Truck(10));

        Car car1 = entityManager.find(Car.class, 1);
        Car car2 = entityManager.find(Car.class, 2);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}