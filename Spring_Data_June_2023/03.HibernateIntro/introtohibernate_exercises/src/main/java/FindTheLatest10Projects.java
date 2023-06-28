import entities.Project;

import java.util.List;

public class FindTheLatest10Projects {
    public static void main(String[] args) {

        Utils.createEntityManager()
                .createQuery("FROM Project ORDER BY name, startDate desc", Project.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(Project::printFormatLatest10Projects);

    }
}
