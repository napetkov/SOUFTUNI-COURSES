import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager("soft_uni");

        entityManager.getTransaction().begin();

        List<Town> allTowns = entityManager.createQuery("FROM Town", Town.class).getResultList();

//        allTowns.stream().filter(t -> t.getName().length() > 5).forEach(entityManager::detach);
//        for (Town town : allTowns) {
//            town.setName(town.getName().toUpperCase());
//            entityManager.persist(town);
//        }

        for (Town town : allTowns) {
            if(town.getName().length() > 5){
                entityManager.detach(town);
                continue;
            }

            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        }


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

