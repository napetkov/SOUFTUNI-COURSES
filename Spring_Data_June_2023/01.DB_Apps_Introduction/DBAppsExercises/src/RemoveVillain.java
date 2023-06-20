import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    private static final String GET_VILLAIN_NAME_BY_ID = "select name from villains where id = ?; ";
    private static final String GET_COUNT_OF_MINIONS_BY_VILLAINS_ID = "select count(minion_id) as m_count from minions_villains where villain_id = ?; ";
    private static final String DELETE_MINIONS_VILLAINS_BY_VILLAINS_ID = "delete from minions_villains where villain_id = ? ";
    private static final String DELETE_VILLAINS_BY_ID = "delete from villains where id = ?; ";

    private static final String COUNT_OF_DELETED_MINIONS_PRINT_FORMAT = "%d minions released\n";
    private static final String DELETED_VILLAINS_PRINT_FORMAT = "%s was deleted\n";
    private static final String NO_SUCH_VILLAINS_FOUND_PRINT_FORMAT = "No such villain was found\n";


    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement getVillainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        getVillainStatement.setInt(1,villainId);

       final ResultSet villainResultSet = getVillainStatement.executeQuery();

        if (!villainResultSet.next()) {
            System.out.println(NO_SUCH_VILLAINS_FOUND_PRINT_FORMAT) ;
            connection.close();
            return;
        }

        final String villainName = villainResultSet.getString(1);

        final PreparedStatement countOfDeletedMinionsStatement = connection.prepareStatement(GET_COUNT_OF_MINIONS_BY_VILLAINS_ID);
        countOfDeletedMinionsStatement.setInt(1,villainId);

        final ResultSet countOfMinionsResultSet = countOfDeletedMinionsStatement.executeQuery();
        countOfMinionsResultSet.next();

        int countOfDeletedMinions = countOfMinionsResultSet.getInt(1);

        connection.setAutoCommit(false);

        try ( PreparedStatement releaseMinionsStatement = connection.prepareStatement(DELETE_MINIONS_VILLAINS_BY_VILLAINS_ID);
              PreparedStatement deleteVillainsStatement = connection.prepareStatement(DELETE_VILLAINS_BY_ID)){

            releaseMinionsStatement.setInt(1,villainId);
            releaseMinionsStatement.executeUpdate();


            deleteVillainsStatement.setInt(1,villainId);
            deleteVillainsStatement.executeUpdate();

            connection.commit();

            System.out.printf(DELETED_VILLAINS_PRINT_FORMAT,villainName);
            System.out.printf(COUNT_OF_DELETED_MINIONS_PRINT_FORMAT,countOfDeletedMinions);

        }catch (SQLException sqlException){
            sqlException.printStackTrace();

            connection.rollback();
        }




    }
}
