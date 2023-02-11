import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Started....");
        Connection connection = null;
        try {
            System.out.println("We will connect to database");
            connection = DBConnection.getConnection();
            System.out.println("We connected to database");

        } catch (SQLException e) {
            System.out.println("We couldn't connect to database!");
            e.printStackTrace();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

}
