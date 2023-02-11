import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Started....");
        try {
            System.out.println("We will connect to database");
            getConnection();
            System.out.println("We connected to database");
        } catch (SQLException e) {
            System.out.println("We couldn't connect to database!");
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda_db", "javaee21", "javaee21");
        return conn;
    }

}
