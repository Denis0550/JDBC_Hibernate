import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {

    public static void main(String[] args) {

        try (final Connection connection = DBConnection.getConnection()) {
            try (Statement stmt = connection.createStatement()) {

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
