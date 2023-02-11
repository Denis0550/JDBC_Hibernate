import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {

    public static void main(String[] args) {
        String updateString = "update persons SET city = ? WHERE personId = ?";
        try (final Connection connection = DBConnection.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(updateString);
            preparedStatement.setString(1, "Tartu");
            preparedStatement.setString(2, "3");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
