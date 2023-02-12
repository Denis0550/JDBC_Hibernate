package akin;

import database.DBConnection;

import java.sql.*;

public class ExampleMain {

    /*
    create table advertisement(
        carRegistrationNumber varchar(255),
        price int
    );
    */

    /*
    create table car(
        Make varchar(255),
        Model varchar(255),
        Year int,
        RegistrationNumber varchar(255),
        Fuel varchar(255),
        Milage int,
        Color varchar(255)
    );

    CREATE PROCEDURE `get_all_cars_with_price` ()
    BEGIN
        SELECT * FROM car,advertisement where car.RegistrationNumber = advertisement.carRegistrationNumber;
    END
    */

    public static void main(String[] args) {


        try (final Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("truncate table car");
            statement.execute("truncate table advertisement");

            statement.executeUpdate("insert into car values('Toyota','RAV4',2021,'123ABC','Diesel',15000,'Black')");
            statement.executeUpdate("insert into car values('Toyota','Corolla',2022,'123DEF','Gas',20000,'White')");
            statement.executeUpdate("insert into car values('VW','Golf',2023,'123GHI','EV',25000,'Grey')");

            statement.executeUpdate("insert into advertisement values('123ABC',25000)");
            statement.executeUpdate("insert into advertisement values('123DEF',30000)");
            statement.executeUpdate("insert into advertisement values('123GHI',35000)");

            String SQL = "{call get_all_cars_with_price ()}";
            CallableStatement callableStatement = connection.prepareCall(SQL);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("Make").concat(" "));
                System.out.print(resultSet.getString("Model").concat(" "));
                System.out.print(Integer.toString(resultSet.getInt("Year")).concat(" "));
                System.out.print(resultSet.getString("RegistrationNumber").concat(" "));
                System.out.print(resultSet.getString("Fuel").concat(" "));
                System.out.print(Integer.toString(resultSet.getInt("Milage")).concat(" "));
                System.out.println(Integer.toString(resultSet.getInt("Price")).concat(" "));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
