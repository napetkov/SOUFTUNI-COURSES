import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Utils {

    static EntityManager createEntityManager(String database){

    return Persistence.createEntityManagerFactory(database).createEntityManager();

    }

}
