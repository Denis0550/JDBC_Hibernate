package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {

    public static void main(String[] args) {

        try (final Connection connection = DBConnection.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery("select * from persons");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("personId").concat(" "));
                    System.out.print(resultSet.getString("firstName").concat(" "));
                    System.out.print(resultSet.getString("lastName").concat(" "));
                    System.out.print(resultSet.getString("address").concat(" "));
                    System.out.println(resultSet.getString("city").concat(" "));
//                    System.out.print(resultSet.getString(1).concat(" "));
//                    System.out.print(resultSet.getString(2).concat(" "));
//                    System.out.print(resultSet.getString(3).concat(" "));
//                    System.out.print(resultSet.getString(4).concat(" "));
//                    System.out.println(resultSet.getString(5));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
