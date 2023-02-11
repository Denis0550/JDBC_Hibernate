import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {

    public static void main(String[] args) {

        try (final Connection connection = DBConnection.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery("select * from persons");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("personId"));
                    System.out.println(resultSet.getString("firstName"));
                    System.out.println(resultSet.getString("lastName"));
                    System.out.println(resultSet.getString("address"));
                    System.out.println(resultSet.getString("city"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
