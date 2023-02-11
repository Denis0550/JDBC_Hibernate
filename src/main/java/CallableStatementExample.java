import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExample {

    public static void main(String[] args) {
//        try (final Connection connection = DBConnection.getConnection()) {
//            String SQL = "{call get_people_who_lives_in_tartu ()}";
//            CallableStatement callableStatement = connection.prepareCall(SQL);
//            ResultSet resultSet = callableStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.print(resultSet.getString("personId").concat(" "));
//                System.out.print(resultSet.getString("firstName").concat(" "));
//                System.out.print(resultSet.getString("lastName").concat(" "));
//                System.out.print(resultSet.getString("address").concat(" "));
//                System.out.println(resultSet.getString("city").concat(" "));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try (final Connection connection = DBConnection.getConnection()) {
            String SQL = "{call get_people_by_city (?)}";
            CallableStatement callableStatement = connection.prepareCall(SQL);
            callableStatement.setString(1, "Tallinn/Estonia");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("personId").concat(" "));
                System.out.print(resultSet.getString("firstName").concat(" "));
                System.out.print(resultSet.getString("lastName").concat(" "));
                System.out.print(resultSet.getString("address").concat(" "));
                System.out.println(resultSet.getString("city").concat(" "));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
