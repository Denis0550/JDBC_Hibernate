package hibernate;

import hibernate.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

            Session session = sessionFactory.openSession();

            Car car = new Car();
            //car.setId(); -> no need this, id will be generated automatically
            car.setMark("Toyota");
            car.setModel("RAV4");
            car.setColor("White");
            car.setFuel("Diesel");
            car.setYear(2019);
            car.setRegistrationNumber("123ABC");
            car.setMilage(15000);

            session.save(car);

            session.close();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

    }

}
