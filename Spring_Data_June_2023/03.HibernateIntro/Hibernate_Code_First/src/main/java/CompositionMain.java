import composition.CompositionCar;
import composition.PlateNumber;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class CompositionMain {

    public static void main(String[] args) {
        EntityManager entityManager = Utils.creteEntityManager();

        entityManager.getTransaction().begin();

//        CompositionCar car = new CompositionCar("Opel", 1200);
//        CompositionCar car2 = new CompositionCar("Skoda", 1300);
//        PlateNumber number = new PlateNumber("CB4444BC", LocalDate.now());
//
//        car.setPlateNumber(number);
//        number.setCar(car2);
//
//
//        entityManager.persist(number);
//        entityManager.persist(car);
//        entityManager.persist(car2);
//
//        CompositionCar compositionCar = entityManager.find(CompositionCar.class, 6);
//        PlateNumber plateNumber = entityManager.find(PlateNumber.class, 5);
//
//        System.out.println();


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
