package homework.jdbc;

import database.DBConnection;

import java.sql.*;

public class MainJDBCExample {

    public static void main(String[] args) {

        insertEmployee("26545421536", "John", "Doe", 1000);
        //deleteEmployee("26545421536");
        updateEmployee("26545421536", "John", "Doe", 2000);
        findByPersonalId("26545421536");
    }

    static void insertEmployee(String personalId, String name, String surname, int salary) {
        // i suggest to use prepared statement!
        try (final Connection connection = DBConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into employee (personal_id,name,surname,salary)  values('" + personalId + "','" + name + "','" + surname + "'," + salary + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void deleteEmployee(String personalId) {
        try (final Connection connection = DBConnection.getConnection();) {
            PreparedStatement statement = connection.prepareStatement("delete from employee where personal_id=?");
            statement.setString(1, personalId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void updateEmployee(String personalId, String name, String surname, int salary) {
        /* i suggest to use prepared statement!
        try (final Connection connection = DBConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "update employee set personal_id='" + personalId + "',name='" + name + "',surname='" + surname + "',salary=" + salary + " where personal_id='" + personalId + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */
        // suggest way of update using prepared statement
        try (final Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update employee set personal_id=?,name=?,surname=?,salary=? where personal_id=?");
            statement.setString(1, personalId);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setInt(4, salary);
            statement.setString(5, personalId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void findByPersonalId(String personalId) {
        try (final Connection connection = DBConnection.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call get_employee_with_personal_id(?) }");
            callableStatement.setString(1, personalId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
            }

        } catch (Exception e) {

        }
    }


}
