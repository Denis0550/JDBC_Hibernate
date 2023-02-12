package hibernate;

import hibernate.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.save(getCar());

            Transaction transaction1 = session.beginTransaction();
            session.save(getCar());
            transaction1.commit();

            /*
            try( start session with try with resource ){
                start transaction
                do some data operations
                commit transaction
            }catch (){
                if an exception occurs rollback transaction here
            }
            */

            /*
            try( start session with try with resource ){
                start transaction
                save incoming request to log table
                commit transaction

                start transaction
                do some data operations
                commit transaction -> but assume that we couldnt complete the operation

            }catch (){
                if an exception occurs rollback transaction here
            }
            */

            Transaction transaction = session.beginTransaction();
            session.save(getCar());
            transaction.rollback();

            session.close();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

    }

    private static Car getCar() {
        Car car = new Car();
        //car.setId(); -> no need this, id will be generated automatically
        car.setMake("Toyota");
        car.setModel("RAV4");
        car.setColor("White");
        car.setFuel("Diesel");
        car.setYear(2019);
        car.setRegistrationNumber("123ABC");
        car.setMilage(15000);
        return car;
    }

}
