import java.sql.*;

public class PrintAllMinionNames {
    private static final String GET_MINIONS_NAME = "select name from minions; ";

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        final PreparedStatement minionsNamesStatement = connection.prepareStatement(
                GET_MINIONS_NAME,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        final ResultSet resultSet = minionsNamesStatement.executeQuery();

        int minionCount = 0;
        int minionStart = 1;
        while (resultSet.next()) {
            minionCount++;
        }

        // half count of minions to not duplicate records!
        final int halfCountOfMinions = minionCount / 2;

        while (minionStart <= halfCountOfMinions) {
            resultSet.absolute(minionStart);
            System.out.println(resultSet.getString(1));
            resultSet.absolute(minionCount);
            System.out.println(resultSet.getString(1));
            minionStart++;
            minionCount--;
        }
    }
}
