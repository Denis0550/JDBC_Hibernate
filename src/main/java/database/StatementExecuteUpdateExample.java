package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExecuteUpdateExample {

    public static void main(String[] args) {
        try (final Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            //int rowCount = statement.executeUpdate("insert into persons values(4,'Name 1','Surname 1','Tartu Mnt','Tallinn')");
            //System.out.println("Inserted row count is " + rowCount);
            int rowCount = statement.executeUpdate("update persons set city='Tallinn/Estonia'");
            System.out.println("updated row count is " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
