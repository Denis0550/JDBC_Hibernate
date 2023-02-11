import java.sql.Connection;

public class DatabaseConnectionWithTry {

    public static void main(String[] args) {

        try (final Connection connection = DBConnection.getConnection()) {
            System.out.println(connection.getMetaData());
            System.out.println(connection.getClientInfo());
            System.out.println(connection.getCatalog());
            System.out.println("we connected to database!");
        } catch (Exception e) {
            System.out.println("Houston we have a problem!");
        }

    }

}
