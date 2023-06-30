import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Utils {
    static EntityManager creteEntityManager(){
        return Persistence.createEntityManagerFactory("relations").createEntityManager();
    }
}
