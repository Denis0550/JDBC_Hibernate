import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Started....");
        Connection connection = null;
        try {
            System.out.println("We will connect to database");
            connection = getConnection();
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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sda_db", Credentials.DB_USER_NAME, Credentials.DB_PASSWORD);
    }

}
